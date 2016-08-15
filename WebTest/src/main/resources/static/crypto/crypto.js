
var CRYPTO_SALT = "4acfedc7dc72a9003a0dd721d7642bde";
var CRYPTO_IV = "69135769514102d0eded589ff874cacd";

function crypto_encrypt(plain, passphrase) {
	var salt = CryptoJS.enc.Hex.parse(CRYPTO_SALT);
	var iv = CryptoJS.enc.Hex.parse(CRYPTO_IV);
	var key128Bits100Iterations = CryptoJS.PBKDF2(passphrase, salt, {keySize: 128/32, iterations: 100});
	var encrypted = CryptoJS.AES.encrypt(plain, key128Bits100Iterations, {iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7});
	return encrypted;
}

function crypto_decrypt(encrypted, passphrase) {
	var salt = CryptoJS.enc.Hex.parse(CRYPTO_SALT);
	var iv = CryptoJS.enc.Hex.parse(CRYPTO_IV);
	var key128Bits100Iterations = CryptoJS.PBKDF2(passphrase, salt, {keySize: 128/32, iterations: 100});
	var decrypted = CryptoJS.AES.decrypt(encrypted, key128Bits100Iterations, {iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7});
	return decrypted.toString(CryptoJS.enc.Utf8);
}
