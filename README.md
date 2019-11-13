# intern-winter-2019
2019年冬季インターンシップ用アプリ

## アプリの仕様

### テーマ候補
A. ToDoアプリ  
B. デジタル時計  
C. レストランの注文アプリ  
D. チャット  

### 搭載機能候補
a. 簡単な通信機能  
b. GUI  
c. 

## 環境設定

IntelliJ IDEA を使用。  
Git操作はIntelliJ外でやることを想定している。  
以下手順を行えばIntelliJ上で読み書きできるようになる、はず。

1. リポジトリをClone
2. IntelliJ IDEAでローカルリポジトリのルートを指定してOpen
3. File -> Project Structure を開く
4. Project -> Project SDK でインストール済みの任意のJDKを設定
5. Project -> Project language level を手順4以下に設定
6. Modules -> Sources で src にカーソルを合わせてからMark as：Sourcesをクリック
7. Modules -> Paths で use module compile output path にチェック
8. Output path: には任意のパスを指定(ex. リポジトリのルートにoutフォルダを作成して指定するなど)
