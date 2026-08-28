export function StatCard({ titulo, valor, children, corFundoIcone }) {
  return (
    <div className="rounded-xl border border-gray-200 bg-white text-foreground shadow-sm">
      <div className="p-6">
        <div className="flex justify-between items-start">
          <div className={`p-3 rounded-xl flex items-center justify-center ${corFundoIcone}`}>
            {children}
          </div>
        </div>
        <div className="mt-4">
          <h3 className="text-2xl font-bold tracking-tight">{valor}</h3>
          <p className="text-sm text-gray-500 font-medium mt-1">{titulo}</p>
        </div>
      </div>
    </div>
  );
}