/** @type {import('tailwindcss').Config} */
module.exports = {
  important: true,
  mode: 'jit',
  content: ["../resources/**/*.{html,js}","./src/**/*.{html,js}","./src/main/resources/*.{html,js}"],
  theme: {
    colors:{
      background: '#2B313F',
      fontPrimary: '#EAF4FC',
      fontSecondary: '#212530',
      cardBackground: '#3f4a65',
    },
    extend: {},
  },
  plugins: [],
}

