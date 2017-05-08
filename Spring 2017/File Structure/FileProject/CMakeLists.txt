cmake_minimum_required(VERSION 3.7)
project(FileProject)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp SecondaryRecord.h SecondaryRecord.cpp IndexRecord.h IndexRecord.cpp ClientData.h ClientData.cpp )
add_executable(FileProject ${SOURCE_FILES})