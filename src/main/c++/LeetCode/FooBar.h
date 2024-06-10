#include <condition_variable>
#include <functional>
#include <mutex>

using namespace std;

class FooBar {
    std::condition_variable cv;
    std::mutex mut;

   private:
    int n;
    int m;

   public:
    FooBar(int n) {
        this->n = n;
        this->m = 1;
    }

    void foo(function<void()> printFoo) {
        std::unique_lock<std::mutex> lock(mut);

        for (int i = 0; i < n; i++) {
            cv.wait(lock, [this]() { return m % 2 != 0; });
            // printFoo() outputs "foo". Do not change or remove this line.
            printFoo();
            m++;
            cv.notify_all();
        }
    }

    void bar(function<void()> printBar) {
        std::unique_lock<std::mutex> lock(mut);

        for (int i = 0; i < n; i++) {
            cv.wait(lock, [this]() { return m % 2 == 0; });

            // printBar() outputs "bar". Do not change or remove this line.
            printBar();
            m++;
            cv.notify_all();
        }
    }
};