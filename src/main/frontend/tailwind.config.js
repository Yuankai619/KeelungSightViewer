/** @type {import('tailwindcss').Config} */
module.exports = {
  important: true,
  mode: 'jit',
  // purge: {
  //   enabled: true,
  //   content: [
  //     "../resources/**/*.{html,js}",
  //       "./src/**/*.{html,js}"
  //   ],
  //   options: {
  //     safelist: [
  //       // 使用通配符保留所有類名
  //       // {
  //         /.*/,peer,
  //       // }
  //     ],
  //   },
  // },
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

