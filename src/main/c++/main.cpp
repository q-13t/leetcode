#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/Solution.h"

using namespace std;
Solution solution;
std::condition_variable cv;
std::mutex mut;
int order = 0;
template <typename T>
void print_vec(std::vector<T>& vec);

void wait() {
    std::unique_lock<std::mutex> lock(mut);
    std::cerr << "waiting1" << std::endl;
    cv.wait(lock, []() { return order == 2; });
    std::cerr << "done1" << std::endl;
    order = 2;
    cv.notify_all();
}
void wait2() {
    std::unique_lock<std::mutex> lock(mut);
    std::cerr << "waiting2" << std::endl;
    cv.wait(lock, []() { return order == 1; });
    std::cerr << "done2" << std::endl;
}

void notif() {
    std::this_thread::sleep_for(std::chrono::seconds(5));

    order = 1;
    cv.notify_all();
}

int main(int argc, char const* argv[]) {
    Foo foo;

    std::cout << "" << std::endl;

    thread t1(wait), t2(wait2), t3(notif);

    t1.join();
    t2.join();
    t3.join();
    return 0;
}

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