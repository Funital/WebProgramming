import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server:{
    proxy:{
      // events로 시작하는 요청을 전달
      // target: 실제 요청을 처리할 Express 서버
      // changeOrigin: 프록시가 백엔드로 전달하는 요청의 Host 헤더를 대상 서버에 맞게 변경하는 옵션
      '/events':{
        target:'http://localhost:3000',
        changeOrigin:true
      }
    }
  }
})
