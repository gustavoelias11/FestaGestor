/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        danger: '#DC2626',       // Vermelho
        primaryDark: '#1E3A8A',  // Azul escuro
        primary: '#2563EB',      // Azul
        success: '#10B981',      // Verde
        warning: '#F59E0B',      // Laranja
        background: '#F8FAFC',   // Fundo
        foreground: '#0F172A',   // Texto principal
      }
    },
  },
  plugins: [],
}