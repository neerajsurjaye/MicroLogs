@echo ========
@echo Building Article Image
@echo ========

docker build -t article:latest %~dp0

@echo ========
@echo Article Image built
@echo ========