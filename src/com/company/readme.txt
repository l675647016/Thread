创建线程的4中方式：
    1、继承Thread类创建线程
    2、实现Runnable接口创建线程
    3、实现Callable接口通过FutureTask包装器来创建Thread线程
    4、使用ExecutorService、Callable、Future实现有返回结果的线程