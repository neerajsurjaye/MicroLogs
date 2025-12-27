@echo ========
@echo Building Gateway Image
@echo ========

docker build -t gateway:latest %~dp0

@echo ========
@echo Gateway Image built
@echo ========