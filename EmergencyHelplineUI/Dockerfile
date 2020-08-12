FROM node:12.2.0-alpine

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY EmergencyHelplineUI/package.json /app/package.json
RUN cd /app; npm install -production

# add app
COPY EmergencyHelplineUI/. /app

# start app
CMD ng serve --host 0.0.0.0 --disableHostCheck
