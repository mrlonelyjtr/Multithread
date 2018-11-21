# Multithread  
## Single Threaded Execution模式  
![FPp6Hg.png](https://s1.ax1x.com/2018/11/21/FPp6Hg.png)  
### 语境  
多个线程共享实例时。  
### 问题  
如果各个线程都随意地改变实例状态，实例会失去安全性。  
### 解决方案  
首先，严格地规定实例的不稳定状态的范围（临界区）。接着，施加保护，确保临界区只能被一个线程执行。这样就可以确保实例的安全性。  
### 实现  
Java可以使用synchronized来实现临界区。  
## Immutable模式  
[![FPpfCn.md.png](https://s1.ax1x.com/2018/11/21/FPpfCn.md.png)](https://imgchr.com/i/FPpfCn)  