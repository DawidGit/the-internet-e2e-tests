FROM ruby:2.7.2

ADD the-internet-ui/Gemfile /app/
ADD the-internet-ui/Gemfile.lock /app/
WORKDIR /app
RUN bundle install
ADD . /app

EXPOSE 5000
CMD ["bundle", "exec", "rackup", "--host", "0.0.0.0", "-p", "5000"]
