FROM node:12.2.0-alpine

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY EmergencyHelplineBFF/package.json /app/package.json
RUN cd /app; npm install -production

# add app
COPY EmergencyHelplineBFF/. /app

# start app
CMD npm run start --host 0.0.0.0 --disableHostCheck
