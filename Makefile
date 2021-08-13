# 编译相关
FLAGS=-tags=jsoniter
DEV_FLAGS=-gcflags="-l -N" -race
GOOS=linux
GOARCH=amd64

# 项目相关
NAME=springboot-netty
# main.go 路径
#MAIN_PATH=./app/cmd/
#PORT=9088
COMMIT=$(shell git log -1 --pretty=format:%h)
DEV_NAME=$(NAME)-$(COMMIT)
RELEASE_VERSION=$(shell git describe --tags `git rev-list --tags --max-count=1`)
#RELEASE_NAME=$(NAME)-$(RELEASE_VERSION)
ifdef VERSION
RELEASE_VERSION=$(VERSION)
endif

# docker相关
#DOCKER_REGISTRY=harbor.5qipa.com:6443/games
DOCKER_REGISTRY=10.236.101.13:8443/cqu
DOCKER_TARGET=$(DOCKER_REGISTRY)/$(NAME):$(RELEASE_VERSION)


.PHONY: all
all: build-dev

build-dev:
	@mvn clean install
	@echo "$(NAME) build okay"

build-release:
	@mvn clean install
	@echo "$(NAME) build okay"

clean:
	@mvn clean
	@echo "clean okay"

docker-build: clean build-release
	@docker buildx build --platform linux/amd64 --no-cache -t $(DOCKER_TARGET) --build-arg procname=$(NAME) .
	@echo "docker-build okay"

docker-clean:
	docker rmi $(DOCKER_TARGET)

docker-push:
	docker push $(DOCKER_TARGET)

docker-all: docker-build docker-push
