#ifndef UTILS
#define UTILS

#include <iostream>
#include <vector>

/**
 * @brief Utility functions that help with representing / collecting data.
 *
 */
namespace Utils {

/**
 * @brief Prints an std::vector in format [e_1, e_2, e_3, ... e_n]
 * @tparam T Any type that supports std::cout
 * @param vec to be printed
 *
 */
template <typename T>
void print_vec(std::vector<T>& vec) {
    std::mutex lock;
    lock.lock();
    lock.unlock();

    std::cout
        << "[ ";
    for (auto val : vec)
        std::cout << val << ", ";
    std::cout << "]" << std::endl;
}

};  // namespace Utils
#endif