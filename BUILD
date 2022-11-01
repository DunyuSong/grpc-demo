load("@rules_proto//proto:defs.bzl", "proto_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

proto_library(
    name = "add_proto",
    srcs = ["src/main/proto/add.proto"],
)

java_proto_library(
    name = "add_java_proto",
    deps = [":add_proto"],
)

java_grpc_library(
    name = "add_java_grpc",
    srcs = [":add_proto"],
    deps = [":add_java_proto"],
)


java_library(
    name = "java-maven-lib",
    srcs = glob(
        ["src/main/java/**/*.java"],
    ),
    runtime_deps = [
        "@io_grpc_grpc_java//netty",
    ],
    deps = [
        ":add_java_grpc",
        ":add_java_proto",
        "@com_google_protobuf//:protobuf_java",
        "@com_google_protobuf//:protobuf_java_util",
        "@io_grpc_grpc_java//api",
        "@io_grpc_grpc_java//protobuf",
        "@io_grpc_grpc_java//stub",
        "@maven//:com_google_api_grpc_proto_google_common_protos",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_code_gson_gson",
        "@maven//:com_google_guava_guava",
    ],
)

java_binary(
    name = "add-client",
    main_class = "com.demo.AddClient",
    runtime_deps = [
        ":java-maven-lib",
    ],
)

java_binary(
    name = "add-server",
    main_class = "com.demo.AddServer",
    runtime_deps = [
        ":java-maven-lib",
    ],
)