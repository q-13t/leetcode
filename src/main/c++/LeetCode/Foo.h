#include <condition_variable>
#include <functional>
#include <mutex>
using namespace std;

class Foo {
    std::condition_variable cv;
    std::mutex mutex;
    int order = 0;

   public:
    Foo() {}

    void first() {
        std::cout << "First" << std::endl;
        order = 1;
        cv.notify_all();
    }

    void second() {
        std::unique_lock<std::mutex> unlock(mutex);
        cv.wait(unlock, [this]() { return order == 1; });
        // printSecond() outputs "second". Do not change or remove this line.
        std::cout << "Second" << std::endl;
        order = 2;
        cv.notify_all();
    }

    void third() {
        std::unique_lock<std::mutex> unlock(mutex);
        cv.wait(unlock, [this]() { return order == 2; });
        std::cout << "Third" << std::endl;
    }
};