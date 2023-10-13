**I. Mô tả hệ thống**
Hệ thống có 3 màn hình

**A. T001(Login)**
  1. Đăng nhập vào hệ thống
  2. Clear màn hình bao gồm cả Error message
  3. Manual form validation with Javascript

**B. T002(Search)**
  1. Hiển thị danh sách thông tin Customer
  2. Thực hiện phân trang
  3. Xây dựng chức năng search theo điều kiện trên màn hình
  4. Manual form validation with Javascript
  5. Thực hiện chức năng xóa Customer có checkbox được chọn

**c. T003(Edit)**
  1. Nếu được truyền CustomerID thì thực hiện chức năng Edit
  2. Ngược lại, nếu không được truyền CustomerID thì thực hiện chức năng Add
  3. Clear màn hình bao gồm cả Error message
  4. Manual form validation with Javascript

**II. Cách cài đặt và sử dụng:**

**A. Java Development Kit (JDK):** 
**Bước 1: Tải JDK:**
1. Truy cập trang web chính thức của Oracle JDK tại đây: https://www.oracle.com/java/technologies/javase-downloads.html
2. Chọn phiên bản cài đặt: jdk1.8.0_191
3. Chấp nhận các điều khoản và điều kiện và tìm phiên bản JDK phù hợp với hệ điều hành của bạn (Windows, macOS, hoặc Linux).
4. Nhấp vào liên kết để tải tệp cài đặt của JDK xuống máy tính của bạn.

**Bước 2: Cài đặt JDK**
1. Mở tệp tải về JDK bạn vừa tải về.
2. Một trình cài đặt sẽ xuất hiện. Bạn chỉ cần làm theo các bước hướng dẫn trên màn hình để hoàn thành quá trình cài đặt. Mặc định, JDK sẽ được cài đặt trong thư mục "C:\Program Files\Java".
3. Sau khi cài đặt hoàn thành, bạn có thể kiểm tra phiên bản JDK bằng cách mở Command Prompt (CMD) và nhập lệnh sau: **java -version**

**B. Cài đặt Eclipse:**
1. Tải và cài đặt Eclipse IDE cho Java EE Developers từ trang web chính thức của Eclipse: https://www.eclipse.org/downloads/
2. Khởi động Eclipse sau khi cài đặt xong.

**C. Cài đặt MySQL:**
1. Tải và cài đặt MySQL Database Server từ trang web chính thức của MySQL: https://dev.mysql.com/downloads/mysql/
2. Sau khi cài đặt, khởi động MySQL Server và tạo cơ sở dữ liệu cho ứng dụng của bạn.

**D. Cài đặt và cấu hình Apache Tomcat:**
1. Tải Apache Tomcat từ trang web chính thức của Tomcat: https://tomcat.apache.org/download-10.cgi
2. Sau khi tải xong, giải nén tệp tải về vào một thư mục trên máy tính của bạn.
3. Mở Eclipse, và sau đó chọn "Window" > "Preferences."
4. Trong hộp thoại Preferences, điều hướng đến "Server" và chọn "Runtime Environments."
5. Nhấp vào nút "Add..." để thêm máy chủ Tomcat vào Eclipse.
6. Chọn "Apache Tomcat" và sau đó điều hướng đến thư mục mà bạn đã giải nén Tomcat ở bước 2.
7. Nhấp vào "Finish" để hoàn tất quá trình thêm máy chủ Tomcat.
   
**E. Trình duyệt web**
1.  Để xem và tương tác với ứng dụng Struts của bạn, bạn cần một trình duyệt web như Google Chrome, Mozilla Firefox, hoặc Microsoft Edge.
