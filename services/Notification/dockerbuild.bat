@echo ========
@echo Building Notification Image
@echo ========

docker build -t notification:latest %~dp0

@echo ========
@echo Auth Notification built
@echo ========