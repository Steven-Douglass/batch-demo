FROM node:16-alpine3.14 AS builder
LABEL maintainer="Steven Douglass <smd940@gmail.com>"
WORKDIR /usr/src/app
COPY ./ ./
RUN npm install
RUN npm run build #

FROM nginx:1.21.6-alpine
COPY --from=builder /usr/src/app/dist/batch-demo-fe/ /usr/share/nginx/html