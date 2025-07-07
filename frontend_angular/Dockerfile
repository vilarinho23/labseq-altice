FROM node:18 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:stable-alpine
COPY --from=build /app/dist/labseq-ui/browser /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]

