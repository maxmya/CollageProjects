cmake_minimum_required(VERSION 3.7)
project(OperatorOverloading)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Temp.cpp Temp.h)
add_executable(OperatorOverloading ${SOURCE_FILES})