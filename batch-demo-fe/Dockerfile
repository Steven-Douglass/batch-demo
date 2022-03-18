FROM node:16-alpine3.14 AS builder
WORKDIR /usr/src/app
COPY ./ ./
RUN npm install
CMD ng build

FROM nginx
COPY --from=builder /usr/src/app/dist/batch-demo-fe /usr/share/nginx/html
# COPY /dist/batch-demo-fe /usr/share/nginx/html

# FROM nginx
# COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
# ENTRYPOINT ["nginx", "-g", "daemon off;"]

# FROM node:16-alpine3.14 
# WORKDIR /usr/src/app
# COPY --from=builder /usr/src/app/dist ./dist
# COPY --from=builder /usr/src/app/node_modules ./node_modules
# RUN npm install http-server
# CMD http-server dist/batch-demo-fe -p 4200