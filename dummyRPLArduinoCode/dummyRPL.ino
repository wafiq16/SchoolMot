#include<stdio.h>
#include<stdlib.h>
#include <string.h>
#include<SPI.h>
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>

// Gunakan serial sebagai monitor
#define USE_SERIAL Serial

// Buat object Wifi
ESP8266WiFiMulti WiFiMulti;

// Buat object http
HTTPClient http;

String url = "http://192.168.43.231/arduino/simpan.php?tempq=";

String myData = "isok";
String payload = "";
WiFiClient clientku;
void setup(void) {
  //the HTML of the web page
  USE_SERIAL.begin(115200);
  USE_SERIAL.setDebugOutput(false);

  for (uint8_t t = 4; t > 0; t--) {
    USE_SERIAL.printf("[SETUP] Tunggu %d...\n", t);
    USE_SERIAL.flush();
  }

  WiFi.mode(WIFI_STA);
  //WiFiMulti.addAP("jims", "12344321");// Sesuaikan SSID dan password ini
  //Inisialisasi pin D4 padam ketika NodeMCU pertama kali menyala
  WiFi.begin("jims", "12344321");
  //  WiFi.begin("AndroidAP2AE5", "12344321");
  Serial.begin(115200);
  Serial.println("");
  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());

  Serial.println("Web server started!");
}
void loop(void) {

  //server.handleClient();
  if (WiFi.status() == WL_CONNECTED) {
    postData();
  }
  else {
    Serial.println("WiFi Disconnected");
  }
}

void postData() {
  // Tambahkan nilai suhu pada URL yang sudah kita buat
  USE_SERIAL.print("[HTTP] Memulai...\n");
  String hehe = "yoyoto";
  http.begin(url + "initempq" + "&myData=" + myData + "&hehe=" + hehe);
  // Mulai koneksi dengan metode GET
  USE_SERIAL.print("[HTTP] Melakukan GET ke server...\n");
  int httpCode = http.GET();

  // Periksa httpCode, akan bernilai negatif kalau error
  if (httpCode > 0)
  {
    // Tampilkan response http
    USE_SERIAL.printf("[HTTP] kode response GET: %d\n", httpCode);

    // Bila koneksi berhasil, baca data response dari server
    payload = http.getString(); 
    USE_SERIAL.println(payload);
    if (httpCode == HTTP_CODE_OK) {
      payload = http.getString();
      USE_SERIAL.println(payload);
    }

  }
  else
  {
    USE_SERIAL.printf("[HTTP] GET gagal, error: %s\n", http.errorToString(httpCode).c_str());
  }
  http.end();
  delay(1000);
}
