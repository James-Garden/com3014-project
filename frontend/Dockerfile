FROM node:21-alpine

ARG VITE_USER_API_URL
ENV VITE_USER_API_URL=$VITE_USER_API_URL

COPY . .
RUN npm install -g http-server
RUN npm install
RUN npm run build
EXPOSE 8080
ENTRYPOINT ["http-server", "-P", "http://localhost:8080?", "dist"]
