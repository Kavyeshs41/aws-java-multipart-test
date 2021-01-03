## Install all dependencies

### install
mvn install "/path/to/ pom.xml"

### test
mvn test -f "/path/to/ pom.xml"

### clean
mvn clean -f "/path/to/ pom.xml"

--

Location to reproduce issues with localstack s3 multipart uploads with md5 checksums.

Execute the following commands:
        docker-compose up &
        echo "127.0.0.1       localstack" | sudo tee -a /etc/hosts
        export AWS_ACCESS_KEY_ID=fake && export AWS_DEFAULT_REGION=us-east-1 && export AWS_REGION=us-east-1 && export AWS_SECRET_ACCESS_KEY=fake
        aws s3 --endpoint http://localstack:4566 mb s3://test/
        mvn test

