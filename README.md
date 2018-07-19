Stack used: JDK 8, SpringBoot, H2

Design details: A relational database is used to store key-value pairs of the actual URL and its unique short URL,
                where short URL is used as a key and the original URL as its value.
                The unique URL is generated using alphanumeric characters of length 62.
                The length of the unique URL is 7, which can give 3381098545 unique combinations.
                Once the combinations are exhausted, the length will be increased to get more unique combinations.

---------------------------------------------------------------
Steps for running Docker image:
---------------------------------------------------------------
1) docker pull 1012ankur/url_shortner

2) docker run -p 8080:8080 --name url-shortner 1012ankur/url_shortner

3) Visit http://localhost:8080


---------------------------------------------------------------
Steps for running executable jar:
---------------------------------------------------------------

1) Make sure that JAVA_HOME is already set!!

2) Run the shell script 'boot.sh' to start the SpringBoot application.



