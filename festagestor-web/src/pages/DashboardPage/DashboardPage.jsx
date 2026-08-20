import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { api } from "../../services/api";

export default function DashboardPage() {
  const navigate = useNavigate();
  const [alugueis, setAlugueis] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function carregarDados() {
      try {
        const resposta = await api.get("/alugueis");
        // O Spring devolve uma Page, os dados estão em 'content'
        setAlugueis(resposta.data.content);
      } catch (error) {
        console.error("Erro ao carregar dashboard:", error);
        if (
          error.response &&
          (error.response.status === 401 || error.response.status === 403)
        ) {
          navigate("/");
        }
      } finally {
        setLoading(false);
      }
    }
    carregarDados();
  }, [navigate]);

  const handleLogout = () => {
    localStorage.removeItem("@Festagestor:token");
    navigate("/");
  };

  // Mapeia o status do Java para as cores do seu Tailwind Config
  const getBadgeStyle = (status) => {
    switch (status) {
      case "PENDENTE":
        return "bg-warning text-white border-transparent";
      case "CONFIRMADO":
      case "MONTADO":
        return "bg-primary text-white border-transparent";
      case "FINALIZADO":
      case "ENTREGUE": // Adicionei ENTREGUE baseado no seu HTML
        return "bg-success text-white border-transparent";
      case "CANCELADO":
      case "DEVOLVIDO": // Adicionei DEVOLVIDO baseado no seu HTML
        return "bg-danger text-white border-transparent";
      default:
        return "bg-gray-200 text-foreground border-transparent";
    }
  };

  return (
    <div className="flex min-h-screen bg-background text-foreground">
      {/* SIDEBAR */}
      <div className="w-64 border-r border-gray-200 bg-white h-screen flex flex-col shrink-0 sticky top-0 overflow-y-auto">
        <div className="p-6">
          <div className="flex items-center gap-2 text-primary font-bold text-xl">
            <div className="p-6">
              <Link to="/dashboard" className="block">
                <img
                  src="../../../public/festagestor-logo-transparent.png"
                  alt="FestaGestor"
                  className="h-14 w-full object-contain object-left"
                />
              </Link>
            </div>
          </div>
        </div>

        <nav className="flex-1 px-4 py-2 space-y-1">
          <Link to="/dashboard">
            <div className="flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm font-medium transition-colors cursor-pointer bg-primary text-white">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="w-5 h-5"
              >
                <rect width="7" height="9" x="3" y="3" rx="1"></rect>
                <rect width="7" height="5" x="14" y="3" rx="1"></rect>
                <rect width="7" height="9" x="14" y="12" rx="1"></rect>
                <rect width="7" height="5" x="3" y="16" rx="1"></rect>
              </svg>
              Dashboard
            </div>
          </Link>
          <Link to="/itens">
            <div className="flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm font-medium transition-colors cursor-pointer text-gray-500 hover:bg-gray-100 hover:text-foreground">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="w-5 h-5"
              >
                <path d="M11 21.73a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73z"></path>
                <path d="M12 22V12"></path>
                <polyline points="3.29 7 12 12 20.71 7"></polyline>
                <path d="m7.5 4.27 9 5.15"></path>
              </svg>
              Itens
            </div>
          </Link>
          <Link to="/alugueis">
            <div className="flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm font-medium transition-colors cursor-pointer text-gray-500 hover:bg-gray-100 hover:text-foreground">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="w-5 h-5"
              >
                <path d="M8 2v4"></path>
                <path d="M16 2v4"></path>
                <rect width="18" height="18" x="3" y="4" rx="2"></rect>
                <path d="M3 10h18"></path>
                <path d="M8 14h.01"></path>
                <path d="M12 14h.01"></path>
                <path d="M16 14h.01"></path>
                <path d="M8 18h.01"></path>
                <path d="M12 18h.01"></path>
                <path d="M16 18h.01"></path>
              </svg>
              Aluguéis
            </div>
          </Link>
          <Link to="/clientes">
            <div className="flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm font-medium transition-colors cursor-pointer text-gray-500 hover:bg-gray-100 hover:text-foreground">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="w-5 h-5"
              >
                <path d="M16 21v-2a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v2"></path>
                <path d="M16 3.128a4 4 0 0 1 0 7.744"></path>
                <path d="M22 21v-2a4 4 0 0 0-3-3.87"></path>
                <circle cx="9" cy="7" r="4"></circle>
              </svg>
              Clientes
            </div>
          </Link>
        </nav>

        <div className="p-4 border-t border-gray-200 mt-auto">
          <div className="flex items-center gap-3 px-3 py-2 bg-gray-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-primary/20 text-primary flex items-center justify-center font-bold text-xs uppercase shrink-0">
              A
            </div>
            <div className="flex-1 min-w-0">
              <p className="text-sm font-medium truncate text-foreground">
                Administrador
              </p>
              <p className="text-xs text-gray-500 truncate">admin</p>
            </div>
            <button
              onClick={handleLogout}
              className="text-gray-500 hover:text-danger transition-colors shrink-0"
              title="Sair"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
                className="w-4 h-4"
              >
                <path d="m16 17 5-5-5-5"></path>
                <path d="M21 12H9"></path>
                <path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path>
              </svg>
            </button>
          </div>
        </div>
      </div>

      {/* MAIN CONTENT */}
      <main className="flex-1 flex flex-col min-w-0 overflow-x-hidden">
        <div className="p-8 flex-1 max-w-7xl mx-auto w-full">
          <div className="mb-8">
            <h1 className="text-3xl font-bold tracking-tight text-foreground">
              Dashboard
            </h1>
            <p className="text-gray-500 mt-1">
              Bem-vindo de volta! Aqui está o resumo do seu negócio.
            </p>
          </div>

          {/* CARDS DE RESUMO */}
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
            <div className="rounded-xl border border-gray-200 bg-white text-foreground shadow-sm">
              <div className="p-6">
                <div className="flex justify-between items-start">
                  <div className="p-3 rounded-xl bg-primary/10">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="2"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="w-6 h-6 text-primary"
                    >
                      <path d="M11 21.73a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73z"></path>
                      <path d="M12 22V12"></path>
                      <polyline points="3.29 7 12 12 20.71 7"></polyline>
                      <path d="m7.5 4.27 9 5.15"></path>
                    </svg>
                  </div>
                </div>
                <div className="mt-4">
                  <h3 className="text-2xl font-bold tracking-tight">9</h3>
                  <p className="text-sm text-gray-500 font-medium mt-1">
                    Itens Cadastrados
                  </p>
                </div>
              </div>
            </div>

            <div className="rounded-xl border border-gray-200 bg-white text-foreground shadow-sm">
              <div className="p-6">
                <div className="flex justify-between items-start">
                  <div className="p-3 rounded-xl bg-success/10">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="2"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="w-6 h-6 text-success"
                    >
                      <path d="M8 2v4"></path>
                      <path d="M16 2v4"></path>
                      <rect width="18" height="18" x="3" y="4" rx="2"></rect>
                      <path d="M3 10h18"></path>
                      <path d="M8 14h.01"></path>
                      <path d="M12 14h.01"></path>
                      <path d="M16 14h.01"></path>
                      <path d="M8 18h.01"></path>
                      <path d="M12 18h.01"></path>
                      <path d="M16 18h.01"></path>
                    </svg>
                  </div>
                </div>
                <div className="mt-4">
                  <h3 className="text-2xl font-bold tracking-tight">4</h3>
                  <p className="text-sm text-gray-500 font-medium mt-1">
                    Aluguéis este Mês
                  </p>
                </div>
              </div>
            </div>

            <div className="rounded-xl border border-gray-200 bg-white text-foreground shadow-sm">
              <div className="p-6">
                <div className="flex justify-between items-start">
                  {/* CORREÇÃO AQUI: bg-primary-dark/10 e text-primary-dark */}
                  <div className="p-3 rounded-xl bg-primary-dark/10">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="w-6 h-6 text-primary-dark"><path d="M16 21v-2a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v2"></path><path d="M16 3.128a4 4 0 0 1 0 7.744"></path><path d="M22 21v-2a4 4 0 0 0-3-3.87"></path><circle cx="9" cy="7" r="4"></circle></svg>
                  </div>
                </div>
                <div className="mt-4">
                  <h3 className="text-2xl font-bold tracking-tight">5</h3>
                  <p className="text-sm text-gray-500 font-medium mt-1">Clientes Ativos</p>
                </div>
              </div>
            </div>

            <div className="rounded-xl border border-gray-200 bg-white text-foreground shadow-sm">
              <div className="p-6">
                <div className="flex justify-between items-start">
                  <div className="p-3 rounded-xl bg-success/10">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="2"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      className="w-6 h-6 text-success"
                    >
                      <path d="M16 7h6v6"></path>
                      <path d="m22 7-8.5 8.5-5-5L2 17"></path>
                    </svg>
                  </div>
                </div>
                <div className="mt-4">
                  <h3 className="text-2xl font-bold tracking-tight">
                    R$ 880,00
                  </h3>
                  <p className="text-sm text-gray-500 font-medium mt-1">
                    Faturamento
                  </p>
                </div>
              </div>
            </div>
          </div>

          {/* LISTA DE ALUGUÉIS DINÂMICA */}
          <div className="rounded-xl border border-gray-200 bg-white shadow-sm">
            <div className="flex flex-col space-y-1.5 p-6 border-b border-gray-100">
              <h3 className="font-semibold leading-none tracking-tight text-lg text-foreground">
                Aluguéis por data
              </h3>
              <p className="text-sm text-gray-500 pt-1">
                Os aluguéis de hoje aparecem primeiro. Clique em qualquer
                aluguel para editar o status.
              </p>
            </div>

            <div className="p-6 pt-4">
              <div className="space-y-4">
                {loading && (
                  <p className="text-center text-gray-500 py-4">
                    Buscando dados no servidor...
                  </p>
                )}

                {!loading && alugueis.length === 0 && (
                  <p className="text-center text-gray-500 py-4">
                    Nenhum aluguel encontrado.
                  </p>
                )}

                {/* MAPEANDO OS DADOS DO JAVA FAKER */}
                {!loading &&
                  alugueis.map((aluguel) => (
                    <button
                      key={aluguel.id}
                      type="button"
                      className="w-full flex items-center justify-between text-left p-4 rounded-xl border border-gray-200 bg-white hover:bg-gray-50 transition-colors cursor-pointer"
                    >
                      <div className="flex flex-col">
                        <span className="font-semibold text-foreground">
                          {aluguel.nomeCliente}
                        </span>
                        <span className="text-sm text-gray-500 mt-1">
                          {aluguel.itens && aluguel.itens.length > 0
                            ? aluguel.itens[0].nomeItem
                            : "Sem Itens"}
                        </span>
                      </div>
                      <div className="flex flex-col items-end gap-2">
                        <span className="text-sm font-medium text-foreground">
                          {new Date(aluguel.dataEntrega).toLocaleDateString(
                            "pt-BR",
                          )}
                        </span>
                        {/* O status ganha cor baseada na sua paleta */}
                        <span
                          className={`inline-flex items-center rounded-full border px-2.5 py-0.5 text-xs font-semibold ${getBadgeStyle(aluguel.status)}`}
                        >
                          {aluguel.status}
                        </span>
                      </div>
                    </button>
                  ))}
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}
