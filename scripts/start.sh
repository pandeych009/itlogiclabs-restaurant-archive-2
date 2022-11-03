export LIB-PATH=/home/cpandey/interviews/git/RestaurantMultiModuleProject/service/itlogiclabs-restaurant-billing/target/itlogiclabs-restaurant-billing-0.0.1.jar
java -Dspring.config.location=%SPRING_CONFIG_LOC% -Dlib=%LIB-PATH% -jar ../common/itlogiclabs-common-service/target/itlogiclabs-common-service-0.0.1.jar
