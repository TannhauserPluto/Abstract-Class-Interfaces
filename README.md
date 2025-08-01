# Abstract-Class-Interfaces

这个类实现了 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 接口，主要功能是对联系人（Contact）对象的信息进行编码和解码，实现数据的同步和传输。

### 能实现什么

- **对象序列化与反序列化**：可以把联系人对象（姓名、手机号、邮箱）编码成字符串，或从字符串还原为对象。
- **接口统一规范**：通过实现 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 接口，[Contact](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 类可以和其他实现了该接口的类（如 `Task` 等）统一进行同步操作。

### 怎么实现的

1. **实现接口**：[Contact](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 类实现了 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 接口，必须实现 [getCode()](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、[encode()](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、`decode(String s)` 这三个方法。
2. **getCode()**：返回 "C"，用来标识这是一个联系人对象。
3. **encode()**：将 [name](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、[mobile](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、[email](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 用 `|` 拼接成一个字符串，并输出编码成功提示。
4. **decode(String str)**：将传入的字符串按 `|` 分割，分别赋值给 [name](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、[mobile](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)、[email](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)，并输出解码成功或失败提示。

这样，[Contact](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 对象就可以方便地在不同系统或模块间以字符串形式传递和还原，便于数据同步和存储。  
相关接口定义见 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)


`Task` 类的作用是表示一个“任务”对象，并实现了 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 接口，使任务对象可以被编码为字符串或从字符串还原，便于数据同步、存储和传输。

### 具体作用

- **封装任务信息**：保存任务描述（desc）、日期（day, month, year）和完成状态（isDone）。
- **实现同步接口**：通过实现 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)，可以将任务对象序列化（encode）为字符串，或从字符串反序列化（decode）为对象，方便与其他系统或模块进行数据交换。
- **统一管理**：和 [Contact](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 类一样，`Task` 也有 [getCode()](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 方法（返回 "T"），用于区分不同类型的数据对象。

### 主要方法说明

- [getCode()](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)：返回 "T"，标识这是一个任务对象。
- [encode()](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)：将任务的各个属性拼接成字符串（用 `|` 分隔），如 `"desc|day|month|year|isDone"`，便于存储或传输。
- [decode(String str)](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)：将字符串按 `|` 分割，解析出各个属性值，恢复为任务对象。
- `setDone(boolean status)`：设置任务是否完成。

这样，`Task` 类就可以和 [Contact](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 等其他实现了 [ISyncable](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html) 的类一起，通过统一的接口进行数据同步和管理。  
相关代码见 [Task](vscode-file://vscode-app/d:/Softwares/Code/Microsoft%20VS%20Code/_/resources/app/out/vs/code/electron-browser/workbench/workbench.html)。
