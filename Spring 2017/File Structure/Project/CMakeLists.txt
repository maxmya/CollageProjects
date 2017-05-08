cmake_minimum_required(VERSION 3.7)
project(Project)

set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES main.cpp ClientData.cpp ClientData.h IndexRecord.cpp IndexRecord.h SecondaryRecord.cpp SecondaryRecord.h)
add_executable(Project ${SOURCE_FILES})