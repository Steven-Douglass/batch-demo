FROM node:16-alpine3.14 AS builder
WORKDIR /usr/src/app
COPY ./ ./
RUN npm install
CMD ng build

FROM nginx
COPY --from=builder /usr/src/app/dist/batch-demo-fe /usr/share/nginx/html