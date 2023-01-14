package com.bcafinance.utils;

public class ConstantMessage {

    /*
    Memperbolehkan nilai numerik dari 0 hingga 9.
    Memperbolehkan Huruf besar dan huruf kecil dari a sampai z.
    Yang diperbolehkan hanya garis bawah “_”, tanda hubung “-“ dan titik “.”
    Titik tidak diperbolehkan di awal dan akhir local part (sebelum tanda @).
    Titik berurutan tidak diperbolehkan.
    Local part, maksimal 64 karakter.
     */
//    public final static String REGEX_EMAIL_STRICT = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    /*REGEX*/
    public final static String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    /*
    * Tidak memperbolehkan tanda | (pipa) dan ' (petik 1)
    */
    public final static String REGEX_EMAIL_STANDARD_RFC5322  = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String REGEX_DATE_YYYYMMDD  = "^([0-9][0-9])?[0-9][0-9]-(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])$";
    public final static String REGEX_DATE_DDMMYYYY  = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$";

    public final static String REGEX_STATE_CODE = "";
    public final static String REGEX_STATE_NAME = "";
    /*Global*/
    public final static String SUCCESS_SAVE = "DATA BERHASIL DIBUAT";
    public final static String SUCCESS_FIND_BY = "OK";
    public final static String WARNING_NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String WARNING_DATA_EMPTY = "DATA TIDAK ADA";

    public final static String ERROR_UPLOAD_CSV = "UPLOAD FILE GAGAL ";
    public final static String ERROR_NOT_CSV_FILE = "FORMAT FILE HARUS CSV ";
    public final static String ERROR_DATA_INVALID = "DATA TIDAK VALID";
    public final static String ERROR_INTERNAL_SERVER = "INTERNAL SERVER ERROR";
    public final static String ERROR_MAIL_FORM_JSON = "Malformed JSON request";
    public final static String ERROR_EMAIL_FORMAT_INVALID = "FORMAT EMAIL TIDAK SESUAI (Nomor/Karakter@Nomor/Karakter)";
    public final static String ERROR_PHONE_NUMBER_FORMAT_INVALID = "FORMAT NOMOR HANDPHONE TIDAK SESUAI (+628XX-)";
    public final static String ERROR_DATE_FORMAT_YYYYMMDD = "FORMAT TANGGAL TIDAK SESUAI (YYYY-mm-dd)";

    public final static String ERROR_UNEXPECTED = "UNEXPECTED ERROR";
    public final static String ERROR_UNPROCCESSABLE = "Validation error. Check 'errors' field for details.";

    public final static String ERROR_NO_CONTENT = "PERMINTAAN TIDAK DAPAT DIPROSES";
    public final static String WELCOME_MESSAGE = "This is Springboot BootCamp BCAF BATCH 1";
    public final static String TAKE_TOUR = "Ready To Start";

    /*Customer*/
    public final static String SUCCESS = "";
    public final static String ERROR = "";
    public final static String WARNING_EMAIL_EXIST = "EMAIL SUDAH TERDAFTAR";
    public final static String WARNING_CUSTOMER_NOT_FOUND = "CUSTOMER BELUM TERDAFTAR";

    public final static String WARNING_GEOGRAPHY_NOT_FOUND = "GEOGRAPHY BELUM TERDAFTAR";

    /*Products*/
    public final static String WARNING_PRODUCT_NOT_FOUND = "PRODUK TIDAK DITEMUKAN";
    public final static String WARNING_CODE_INVALID = "KODE TIDAK SESUAI";
    public final static String WARNING_PRODUCT_PRICE_SOP = "HARGA TIDAK BOLEH 1/2 ATAU 3 KALI DARI HARGA SEBELUMNYA";

    /*Employee*/

    /*Discount*/
    public final static String WARNING_USERNAME_MENDATORY = "USERNAME WAJIB DIISI";
    public final static String WARNING_EMAIL_MENDATORY = "ALAMAT EMAIL WAJIB DIISI";
    public final static String WARNING_DISCOUNT_EXIST = "DISCOUNT SUDAH TERDAFTAR";
    public final static String WARNING_EMAIL_EXISTING = "ALAMAT EMAIL SUDAH TERDAFTAR";
    public static final String SUCCESS_SEND_EMAIL = "EMAIL BERHASIL TERKIRIM";
    public final static String EMAIL_VERIF_SUCCES = "EMAIL SUKSES TERVERIFIKASI";

    /* CONTENT TYPE*/
    public final static String CONTENT_TYPE_CSV = "text/csv";

    /* NULL  */

    public final static String VAR1_NULL = "VAR1 TIDAK BOLEH NULL";

    public final static String VAR2_NULL = "VAR2 TIDAK BOLEH NULL";

    public final static String VAR3_NULL = "VAR3 TIDAK BOLEH NULL";

    public final static String WARNING_REQUIRED = "FIELD HARUS DIISI";

    public final static String WARNING_LENGHT = "PANJANG TIDAK SESUAI";

    public final static String WARNING_USER_NOT_FOUND = "USER TIDAK DITEMUKAN";

    public final static String WARNING_LOGIN_FAIL = "LOGIN GAGAL, USERNAME ATAU PASSWORD SALAH";

    public final static String SUCCESS_LOGIN = "BERHASIL LOGIN";

    public final static String WARNING_UNIQ_ID_UNIQ = "UNIQ ID HARUS UNIQ";
    public final static String WARNING_PHONE_NUMBER_UNIQ = "PHONE NUMBER HARUS UNIQ";
    public final static String WARNING_CMS_REQUIRED = "FIELD CMS HARUS DIISI";
    public final static String WARNING_MOBILE_REQUIRED = "FIELD MOBILE HARUS DIISI";





}
