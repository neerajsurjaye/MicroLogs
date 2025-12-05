@echo ========
@echo Building Auth Image
@echo ========

docker build -t auth:latest %~dp0

@echo ========
@echo Auth Image built
@echo ========