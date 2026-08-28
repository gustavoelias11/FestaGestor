import { useState } from "react";

export function ModalEdicaoAluguel({
  isOpen,
  onClose,
  aluguel,
  onSalvar,
  erro,
}) {
  // Inicializamos o estado direto com o status do aluguel (se existir)
  // Como vamos usar a "key" no Pai, isso sempre será o valor mais atualizado!
  const [novoStatus, setNovoStatus] = useState(aluguel ? aluguel.status : "");

  if (!isOpen || !aluguel) return null;

  return (
    <>
      {/* Fundo escurecido (Overlay) */}
      <div
        className="fixed inset-0 z-40 bg-black/50 backdrop-blur-sm"
        onClick={onClose}
      ></div>

      {/* O Modal em si */}
      {/* O Modal em si */}
      <div className="fixed left-1/2 top-1/2 z-50 grid w-full max-w-lg -translate-x-1/2 -translate-y-1/2 gap-4 border border-gray-200 bg-white p-6 shadow-lg sm:rounded-xl sm:max-w-md">
        <div className="flex flex-col space-y-1.5 text-left">
          <h2 className="text-xl font-bold leading-none tracking-tight text-slate-800">
            Editar status do aluguel
          </h2>
          {/* Dados dinâmicos puxados do objeto "aluguel" */}
          <p className="text-sm text-gray-500 mt-2">
            {aluguel.nomeCliente} ·{" "}
            {aluguel.itens?.length > 0 ? aluguel.itens[0].nomeItem : "Sem item"}{" "}
            · {new Date(aluguel.dataEntrega).toLocaleDateString("pt-BR")}
          </p>
        </div>

        <div className="space-y-2 py-4">
          <label
            htmlFor="status"
            className="text-sm font-semibold text-slate-700"
          >
            Status
          </label>

          <select 
            id="status" 
            value={novoStatus}
            onChange={(e) => setNovoStatus(e.target.value)}
            className="flex h-10 w-full rounded-lg border border-gray-300 bg-white px-3 py-2 text-sm shadow-sm focus:outline-none focus:ring-2 focus:ring-primary focus:border-transparent"
          >
            {/* Array com todas as opções possíveis. O .map() vai transformar cada item em uma tag <option> */}
            {[
              { value: 'PENDENTE', label: 'Pendente' },
              { value: 'CONFIRMADO', label: 'Confirmado' },
              { value: 'MONTADO', label: 'Montado' },
              { value: 'FINALIZADO', label: 'Finalizado' },
              { value: 'CANCELADO', label: 'Cancelado' }
            ].map((opcao) => {
              
              // Verifica se a opção atual do loop é o mesmo status que veio do banco de dados
              const isStatusAtual = opcao.value === aluguel?.status;

              return (
                <option 
                  key={opcao.value} 
                  value={opcao.value} 
                  disabled={isStatusAtual} // Bloqueia apenas a opção que o usuário já possui
                >
                  {opcao.label} {isStatusAtual ? '(Status atual)' : ''}
                </option>
              );
            })}
          </select>
        </div>

        {erro && (
          <div className="mb-4 text-sm font-medium text-red-600 bg-red-50 p-2 rounded-md border border-red-200">
            {erro}
          </div>
        )}

        <div className="flex flex-col-reverse sm:flex-row sm:justify-end sm:space-x-2 mt-2">
          <button
            onClick={onClose}
            className="inline-flex items-center justify-center rounded-lg border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-slate-700 shadow-sm hover:bg-slate-50 transition-colors mt-2 sm:mt-0"
          >
            Cancelar
          </button>

          {/* Aqui chamamos a função do PAI passando o ID do aluguel e o novo Status escolhido */}
          <button
            onClick={() => onSalvar(aluguel.id, novoStatus)}
            disabled={novoStatus === aluguel?.status}
            className={`inline-flex items-center justify-center rounded-lg px-4 py-2 text-sm font-medium text-white shadow-md transition-colors ${
              novoStatus === aluguel?.status
                ? "bg-gray-400 cursor-not-allowed"
                : "bg-primary hover:bg-primary/90"
            }`}
          >
            Salvar status
          </button>
        </div>
      </div>
    </>
  );
}
