package org.d3if3050.asesmen1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import org.d3if3050.asesmen1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    private var listData = listOf<Tumbuhan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { cariTanaman() }
        supportActionBar?.hide()
        listData = getData()
    }

    private fun getData(): List<Tumbuhan> {
        return listOf(
            Tumbuhan(
                "Monstera",
                "Monstera Deliciosa",
                "Monstera Deliciosa, juga dikenal sebagai tanaman berdaun besar Swiss Cheese Plant, adalah tanaman indoor populer yang dapat bertumbuh hingga beberapa meter tingginya.",
                "1. Pilih lokasi yang tepat: Monstera Deliciosa membutuhkan cahaya yang cukup untuk tumbuh dengan baik, tetapi hindari sinar matahari langsung yang dapat membakar daun. Letakkan tanaman di dekat jendela yang mendapat sinar matahari pagi atau sore.\n" +
                        "\n" +
                        "2. Tanah yang baik: Pastikan tanah di pot cukup subur dan memiliki drainase yang baik. Anda dapat menambahkan pasir atau serbuk gergaji ke tanah untuk membantu drainase.\n" +
                        "\n" +
                        "3. Air secukupnya: Jangan membiarkan tanah terlalu basah atau terlalu kering. Sebaiknya tanah disiram secara teratur tetapi jangan sampai tergenang air. Sebaiknya siram tanaman setiap 5-7 hari sekali, tergantung pada kondisi lingkungan dan suhu.\n" +
                        "\n" +
                        "4. Pemupukan: Berikan pupuk organik secara teratur selama musim pertumbuhan aktif, biasanya di musim semi dan musim panas.\n" +
                        "\n" +
                        "5. Menjaga kelembapan: Monstera Deliciosa menyukai kelembapan yang cukup tinggi. Anda bisa menyemprotkan air ke daunnya secara teratur atau meletakkan wadah berisi air di sebelah pot untuk menjaga kelembapan udara di sekitarnya.\n" +
                        "\n" +
                        "6. Pot yang sesuai: Pilih ukuran pot yang sesuai dengan ukuran tanaman dan pastikan pot memiliki lubang drainase.\n" +
                        "\n" +
                        "7. Perawatan rutin: Potong daun yang rusak dan bersihkan debu dari daun untuk menjaga kesehatan tanaman.",
                R.drawable.monstera
            ),

            Tumbuhan(
                "Lidah Mertua",
                "Sansevieria trifasciata",
                "Tanaman lidah mertua atau Sansevieria adalah tanaman indoor yang populer karena daya tahan dan kemampuannya untuk membersihkan udara.",
                "1. Pencahayaan: Lidah mertua dapat bertahan hidup dengan cahaya redup atau sinar matahari langsung, tetapi akan tumbuh lebih baik dengan cahaya terang namun tidak langsung. Letakkan tanaman di dekat jendela yang mendapat sinar matahari pagi atau sore.\n" +
                        "\n" +
                        "2. Tanah yang baik: Tanaman lidah mertua dapat tumbuh dalam berbagai jenis tanah, tetapi membutuhkan tanah yang memiliki drainase yang baik. Sebaiknya tanah di pot dicampur dengan pasir atau serbuk gergaji untuk membantu drainase.\n" +
                        "\n" +
                        "3. Air secukupnya: Lidah mertua lebih suka tanah yang kering daripada terlalu basah. Siram tanaman hanya ketika tanah sudah benar-benar kering. Sebaiknya siram tanaman sekitar seminggu sekali, tergantung pada kondisi lingkungan dan suhu.\n" +
                        "\n" +
                        "4. Pemupukan: Pupuk tidak diperlukan secara teratur untuk lidah mertua, tetapi dapat diberikan pupuk cair atau granular selama musim pertumbuhan aktif (musim semi dan musim panas).\n" +
                        "\n" +
                        "5. Perawatan rutin: Bersihkan daun lidah mertua secara teratur untuk menjaga tampilannya tetap segar dan sehat. Anda juga dapat memangkas daun yang kering atau rusak.\n" +
                        "\n" +
                        "6. Pemindahan: Pindahkan tanaman ke pot yang lebih besar setiap dua atau tiga tahun sekali untuk memberikan ruang untuk pertumbuhan.\n" +
                        "\n" +
                        "7. Temperatur: Lidah mertua dapat bertahan hidup pada suhu yang relatif dingin dan suhu kamar yang hangat. Namun, sebaiknya hindari suhu ekstrem yang terlalu panas atau terlalu dingin.",
                R.drawable.lidah_mertua
            ),

            Tumbuhan(
                "Ficus",
                "Ficus benjamina",
                "Tanaman Ficus Benjamina, atau dikenal juga sebagai pohon karet atau weeping fig, adalah tanaman indoor yang populer karena daunnya yang hijau dan indah.",
                "1. Pencahayaan: Ficus Benjamina membutuhkan cahaya yang cukup untuk tumbuh dengan baik, tetapi hindari sinar matahari langsung yang dapat membakar daun. Letakkan tanaman di tempat yang terang dan tidak terkena sinar matahari langsung.\n" +
                        "\n" +
                        "2. Tanah yang baik: Pastikan tanah di pot cukup subur dan memiliki drainase yang baik. Anda dapat menambahkan pasir atau serbuk gergaji ke tanah untuk membantu drainase.\n" +
                        "\n" +
                        "3. Air secukupnya: Jangan membiarkan tanah terlalu basah atau terlalu kering. Sebaiknya siram tanaman secara teratur tetapi jangan sampai tergenang air. Sebaiknya siram tanaman setiap 5-7 hari sekali, tergantung pada kondisi lingkungan dan suhu.\n" +
                        "\n" +
                        "4. Pemupukan: Berikan pupuk organik atau pupuk khusus tanaman Ficus secara teratur selama musim pertumbuhan aktif, biasanya di musim semi dan musim panas.\n" +
                        "\n" +
                        "5. Menjaga kelembapan: Ficus Benjamina menyukai kelembapan yang cukup tinggi. Anda bisa menyemprotkan air ke daunnya secara teratur atau meletakkan wadah berisi air di sebelah pot untuk menjaga kelembapan udara di sekitarnya.\n" +
                        "\n" +
                        "6. Pot yang sesuai: Pilih ukuran pot yang sesuai dengan ukuran tanaman dan pastikan pot memiliki lubang drainase.\n" +
                        "\n" +
                        "7. Perawatan rutin: Potong daun yang rusak dan bersihkan debu dari daun untuk menjaga kesehatan tanaman.\n" +
                        "\n" +
                        "8. Temperatur: Ficus Benjamina tumbuh dengan baik pada suhu yang relatif hangat, antara 16-24 derajat Celsius. Hindari suhu ekstrem yang terlalu panas atau terlalu dingin.",
                R.drawable.ficus
            ),

            Tumbuhan(
                "Pohon Gajah Mini",
                "Alocasia Polly",
                "Tanaman Gajah Mini atau Alocasia Polly adalah tanaman indoor yang populer karena bentuk daunnya yang unik dan menarik.",
                "1. Pencahayaan: Gajah Mini membutuhkan cahaya yang cukup, tetapi hindari sinar matahari langsung yang dapat membakar daun. Letakkan tanaman di tempat yang terang dan tidak terkena sinar matahari langsung.\n" +
                        "\n" +
                        "2. Tanah yang baik: Pastikan tanah di pot cukup subur dan memiliki drainase yang baik. Anda dapat menambahkan pasir atau serbuk gergaji ke tanah untuk membantu drainase.\n" +
                        "\n" +
                        "3. Air secukupnya: Jangan membiarkan tanah terlalu basah atau terlalu kering. Sebaiknya siram tanaman secara teratur tetapi jangan sampai tergenang air. Sebaiknya siram tanaman setiap 5-7 hari sekali, tergantung pada kondisi lingkungan dan suhu.\n" +
                        "\n" +
                        "4. Pemupukan: Berikan pupuk organik atau pupuk khusus tanaman Alocasia Polly secara teratur selama musim pertumbuhan aktif, biasanya di musim semi dan musim panas.\n" +
                        "\n" +
                        "5. Menjaga kelembapan: Alocasia Polly menyukai kelembapan yang cukup tinggi. Anda bisa menyemprotkan air ke daunnya secara teratur atau meletakkan wadah berisi air di sebelah pot untuk menjaga kelembapan udara di sekitarnya.\n" +
                        "\n" +
                        "6. Pot yang sesuai: Pilih ukuran pot yang sesuai dengan ukuran tanaman dan pastikan pot memiliki lubang drainase.\n" +
                        "\n" +
                        "7. Perawatan rutin: Potong daun yang rusak dan bersihkan debu dari daun untuk menjaga kesehatan tanaman.\n" +
                        "\n" +
                        "8. Temperatur: Alocasia Polly tumbuh dengan baik pada suhu yang relatif hangat, antara 18-25 derajat Celsius. Hindari suhu ekstrem yang terlalu panas atau terlalu dingin.\n" +
                        "\n" +
                        "9. Hindari Angin: Alocasia Polly rentan terhadap angin, jadi jangan letakkan tanaman di tempat yang angin terlalu kencang.",
                R.drawable.gajah_mini
            ),
            Tumbuhan(
                "Kaktus",
                "Cactaceae family",
                "Tanaman kaktus merupakan jenis tanaman yang relatif mudah dirawat karena tidak memerlukan banyak air dan perawatan khusus.",
                "1. Pencahayaan: Kaktus membutuhkan sinar matahari yang cukup untuk tumbuh dengan baik. Letakkan kaktus di tempat yang terkena sinar matahari langsung, seperti dekat jendela yang menghadap ke arah selatan atau barat.\n" +
                        "\n" +
                        "2. Air secukupnya: Kaktus memerlukan sedikit air dan sangat rentan terhadap kelebihan air. Sebaiknya siram kaktus setiap 2-3 minggu sekali, tergantung pada kondisi lingkungan dan suhu. Pastikan tanah benar-benar kering sebelum disiram kembali.\n" +
                        "\n" +
                        "3. Tanah yang baik: Tanah untuk kaktus harus memiliki kemampuan drainase yang baik. Campurkan pasir atau kerikil ke dalam tanah untuk membantu drainase.\n" +
                        "\n" +
                        "4. Pemupukan: Berikan pupuk khusus kaktus atau pupuk cair yang disesuaikan untuk kaktus selama musim pertumbuhan aktif, biasanya di musim semi dan musim panas.\n" +
                        "\n" +
                        "5. Pot yang sesuai: Pilih pot yang sesuai dengan ukuran kaktus dan pastikan pot memiliki lubang drainase.\n" +
                        "\n" +
                        "6. Hindari suhu ekstrem: Kaktus tumbuh dengan baik pada suhu antara 21-27 derajat Celsius. Hindari suhu ekstrem yang terlalu panas atau terlalu dingin.\n" +
                        "\n" +
                        "7. Perawatan rutin: Bersihkan debu dari daun dan pot secara berkala untuk menjaga kesehatan tanaman.\n" +
                        "\n" +
                        "8. Hindari manipulasi: Hindari memindahkan atau memutar pot kaktus terlalu sering karena dapat merusak akar yang sensitif.\n" +
                        "\n",
                R.drawable.cactus
            ),
        )
    }

    private fun cariTanaman() {
        val cari = binding.tanamanInp.text.toString().lowercase()
        if (TextUtils.isEmpty(cari)) {
            Toast.makeText(this, R.string.cari_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val filtered = listData.filter { cari.equals(it.nama, ignoreCase = true) }
        if (filtered.isNotEmpty()) {
            filtered.forEach { tumbuhan ->
                binding.details.visibility = View.VISIBLE
                binding.details.text = getString(R.string.details)
                binding.gambar.visibility = View.VISIBLE
                binding.gambar.setImageResource(tumbuhan.imageResId)
                binding.judulTanaman.visibility = View.VISIBLE
                binding.judulTanaman.text = tumbuhan.nama
                binding.deskripsiTanaman.visibility = View.VISIBLE
                binding.deskripsiTanaman.text = tumbuhan.deskripsi
                binding.cara.visibility = View.VISIBLE
                binding.cara.text = tumbuhan.caraMerawat
                binding.namaLatin.visibility = View.VISIBLE
                binding.namaLatin.text = tumbuhan.namaLatin
            }
        } else {
            binding.details.visibility = View.VISIBLE
            binding.details.text = getString(R.string.data_invalid)
            binding.gambar.visibility = View.GONE
            binding.judulTanaman.visibility = View.GONE
            binding.deskripsiTanaman.visibility = View.GONE
            binding.cara.visibility = View.GONE
            binding.namaLatin.visibility = View.GONE

        }


    }
}
