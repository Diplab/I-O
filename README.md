I/O
===
Thinking in Java Ch 18

## Outline

- [前言](#前言)
- [File Class](#file class)
- [位元串流](#位元串流)
- [InputStream、OutputStream](#inputstream、outputstream)
  + [FileInputStream、FileOutputStream](#fileinputstream、fileoutputstream)
  + [ByteArrayInputStream、ByteArrayOutputStream](#bytearrayinputstream、bytearrayoutputstream)
  + [FilterInputStream、FilterOutputStream](#filterinputstream、filteroutputstream)
    * [BufferedInputStream、BufferedOutputStream](#bufferedinputstream、bufferedoutputstream)
    * [DataInputStream、DataOutputStream](#datainputstream、dataoutputstream)
    * [PrintStream](#printstream)
  + [ObjectInputStream、ObjectOutputStream](#objectinputstream、objectoutputstream)

- [字元串流](#字元串流)
- [Reader、Writer](#reader、writer)
  + [InputStreamReader、OutputStreamWriter](#inputstreamreader、outputstreamwriter)
    * [FileReader、FileWriter](#filereader、filewriter)
  + [BufferedReader、BufferedWriter](#bufferedreader、bufferedwriter)
  + [CharArrayReader、CharArrayWriter](#chararrayreader、chararraywriter)
  + [PrintWriter](#printwriter)
- [RandomAccessFile Class](#randomaccessfile class)
- [管線化串流](#管線化串流)


## 前言

當使用程式軟體處理重要資料時，會與檔案的存取有莫大的關係，因為重要的資料最終要存放在檔案中。而且在有需要的時侯，程式還可以將檔案內的資料讀取出來，或再將更新過的資料存入檔案中。

Java 的 I/O 機制建立在串流（stream）的基礎之上，能有效簡化讀寫不同資料型態的程序。Java 為各種應用領域提供了各式各樣的串流， 串流的世界可分成兩大類型：用於讀寫二元資料的 InputStream 與 OutputStream ，以及用於讀寫文字的 Reader 與 Writer。Java 也提供了能讀取加密資料的 CipherInputStream？以及能自動壓縮資料的 ZipOutputStream？

![Stream.png](img/Stream.png)


## File Class

File Class專門提供檔案、目錄管理的功能。例如，檔案的查詢、新增、修改與刪除等功能。File Class不能直接存取檔案內容，必須改用其他類別。例如：FileReader和FileWriter

## 位元串流


## InputStream、OutputStream

從程式的觀點來說，通常會將資料目的地（例如記憶體）與來源（例如檔案）之間的資料流動抽象化為一個串流（Stream），而當中流動的則是位元資料。

![Stream2.png](img/Stream2.png)

在 Java SE 中有兩個類別用來作串流的抽象表示：
- 輸入串流：java.io.InputStream
- 輸出串流：java.io.OutputStream

InputStream 是所有表示位元輸入串流的類別之**父類別**，它是一個**抽象類別**，繼承它的子類別要重新定義當中所定義的抽象方法。InputStream 是從裝置來源地讀取資料的抽象表示，例如System中的標準輸入串流 in 物件就是一個 InputStream 類型的實例，在 Java 程式開始之後，in 串流物件就會開啟，目的是從標準輸入裝置中讀取資料，這個裝置通常是鍵盤或是使用者定義的輸入裝置。

![InputStream.png](img/InputStream.png)

OutputStream 是所有表示位元輸出串流的類別之**父類別**，它是一個**抽象類別**，子類別要重新定義當中所定義的抽象方法，OutputStream 是用於將資料寫入目的地的抽象表示，例如 System 中的標準輸出串流物件 out 其類型是 java.io.PrintStream，這個類別是 OutputStream 的子類別（java.io.FilterOutputStream 繼承 OutputStream， PrintStream 再繼承 FilterOutputStream），在程式開始之後，out 串流物件就會開啟，您可以透過 out 來將資料寫至目的地裝置，這個裝置通常是螢幕顯示或使用者定義的輸出裝置。

![OutputStream.png](img/OutputStream.png)

### FileInputStream、FileOutputStream

### ByteArrayInputStream、ByteArrayOutputStream

### FilterInputStream、FilterOutputStream

#### BufferedInputStream、BufferedOutputStream
![BufferStream.png](img/BufferStream.png)

#### DataInputStream、DataOutputStream
#### PrintStream

### ObjectInputStream、ObjectOutputStream






## 字元串流
## Reader、Writer

![Reader.png](img/Reader.png)
![Writer.png](img/Writer.png)


### InputStreamReader、OutputStreamWriter
#### FileReader、FileWriter

### BufferedReader、BufferedWriter
### CharArrayReader、CharArrayWriter
### PrintWriter

## RandomAccessFile Class

## 管線化串流

PipedInputStream、PipedOutputStream、PipeReader、PipeWriter。這四種也是串流的一種，但必須等到了解多執行緒後才會了解他的價值。因為管線化 streams 被用於執行緒之間的通訊。
