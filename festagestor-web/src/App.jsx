import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import LoginPage from './pages/LoginPage/LoginPage';
import DashboardPage from './pages/DashboardPage/DashboardPage';

export function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Rota inicial carrega o Login */}
        <Route path="/" element={<LoginPage />} />
        
        {/* Rota privada do sistema */}
        <Route path="/dashboard" element={<DashboardPage />} />
        
        {/* Qualquer outra URL digitada redireciona para a raiz */}
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}