**DocSafe**

DocSafe is new way to share and store your important documents. The application is developed using Spring Boot and utilizes AWS S3 to store images of documents.


**Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

**Prerequisites**
Java 11
Maven 3.6.3
AWS S3 account

**Installing**

1. Clone the repository

git clone https://github.com/[your-github-username]/[project-name].git

2. Navigate to the project directory

cd [project-name]

3. Build the project

mvn clean install


**Running the application**

1. Start the application

mvn spring-boot:run

2. Access the application at http://localhost:8081


**Configuration**

Before running the application, you need to configure the AWS S3 credentials in the application.yml file.

amazon:
  s3:
    access-key: [your-access-key]
    secret-key: [your-secret-key]
    region: [your-region]
    bucket-name: [your-bucket-name]

**Built With**
Spring Boot - The web framework used
AWS SDK for Java - The AWS SDK used for accessing S3

**Author**
Deep Patel






