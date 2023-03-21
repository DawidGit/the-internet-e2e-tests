FROM ruby:2.7.2

ADD the-internet-ui/Gemfile /app/
ADD the-internet-ui/Gemfile.lock /app/
ADD the-internet-ui/setup.sh /app/
WORKDIR /app
USER root
RUN chmod +x setup.sh
ADD . /app

EXPOSE 80
CMD ["bundle", "exec", "rackup", "--host", "0.0.0.0", "-p", "80"]
RUN chmod +x setup.sh