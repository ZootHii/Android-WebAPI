package com.zoothii.ders1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zoothii.ders1.model.Brand
import com.zoothii.ders1.repository.BrandRepository
/*import com.zoothii.ders1.repository.Repository*/


class MainActivity : AppCompatActivity() {

    //private lateinit var viewModel: MainViewModel

    private lateinit var brands: ArrayList<Brand>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val brandService = RetrofitService.buildService(IBrandsApi::class.java)
        val call = brandService.getAllBrands()



        call.enqueue(object : Callback<DataResponse<Brand>> {
            override fun onResponse(
                call: Call<DataResponse<Brand>>,
                response: Response<DataResponse<Brand>>
            ) {
                if (response.isSuccessful) {
                    brands = response.body()?.data!!.toCollection(ArrayList()) // array to arrayList cast
                    for (brand in brands){
                        Log.d("List", brand.toString())
                    }
                    *//*Log.d("Message", response.body()?.message.toString())
                    Log.d("Success", response.body()?.success.toString())

                    Log.d("Success", response.body().toString())


                    for (brand in response.body()?.data!!) {
                        Log.d("Response", brand.toString())
                    }*//*
                } else {

                    *//*val jObjError = JSONObject(response.errorBody()!!.string())
                    val str = jObjError.getString("Message")
                    Log.d("SS", str.toString())
                    Log.d("SS", jObjError.toString())

                    Log.d("Success", response.body().toString())
                    Log.d("Success", response.body()?.success.toString())
                    Log.d("Success", response.body()?.message.toString())
                    Log.d("Success", response.message().toString())
                    Log.d("Success", response.body().toString())
                    Log.d("Success", response.toString())
                    if (response.code() == 400){
                        Log.d("Error 400", response.errorBody()?.string().toString())
                        Log.d("Error 400", response.errorBody()?.string().toString())
                    }*//*
                }
            }

            override fun onFailure(call: Call<DataResponse<Brand>>, t: Throwable) {
                *//*Log.d("ERROR", t.message.toString())*//*
            }
        })*/



        val brandRepository = BrandRepository()
        val brandViewModel = BrandViewModel(brandRepository)

        brandViewModel.getAllBrands()
        brandViewModel.brandDataResponse.observe(this, Observer { response ->
            if (response.success){
                /*Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())*/
                for (brand in response.data){
                    Log.d("Response", brand.toString())
                }
            }
            else
            {
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
        })

        brandViewModel.getBrandById(1)
        brandViewModel.brandSingleDataResponse.observe(this, Observer { response ->
            if (response.success){
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
                Log.d("Response", response.data.toString())

            }
            else
            {
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
        })


        brandViewModel.addBrand(Brand(0, "easyEASY"))
        brandViewModel.brandResponse.observe(this, Observer { response ->
            if (response.success){
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
            else
            {
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
        })


        brandViewModel.getAllBrands()
        brandViewModel.brandDataResponse.observe(this, Observer { response ->
            if (response.success){
                /*Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())*/
                for (brand in response.data){
                    Log.d("Response", brand.toString())
                }
            }
            else
            {
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
        })

        /*val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAllBrands()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.success){
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
                for (brand in response.data){
                    Log.d("Response", brand.toString())
                }
            }
            else
            {
                Log.d("Message", response.message.toString())
                Log.d("Success", response.success.toString())
            }
        })*/

        /*Toast.makeText(this, "test", Toast.LENGTH_LONG).show()


        println("---- Variables----")
        var nullableName : String? = "DO I REALLY EXIST ?" // this is null actually
        //var nullName : String = null // not possible to initialize null value
        println(nullableName)

        lateinit var str: String;

        nullableName = null
        var length = 0
        if(nullableName != null){
            length = nullableName.length
        } else {
            length = -1
        }
        println(length)
        val l = if (nullableName != null) nullableName.length else -1
        println(l)
        println(nullableName?.length)

        println("-----Variables2----")
        val PI = 3.14
        val x = 5
        val y = 4
        val x2 : Int = 6
        var x3 : Float = 3.0F
        var x4 : Double = 3.4
        println(x * y)
        println(x * PI)
        println(x2 * y)
        val name1 = "Ahmet"
        val name2 = "Yıldırım"
        println("{$name1} {${name2}")
        val bool = true
        var bool2 : Boolean = true
        println(bool)
        println(bool2)
        println("----")
        println(4 != 5)
        println(4 == 5)

        println("----Arrays, ArrayLists, Sets----")
        val arr = arrayOf(1,2,3)
        val arr2 = intArrayOf(11,22,33)
        val arrList = arrayListOf(111,222,333)
        val arrList2 = arrayListOf("A","B","C")
        val arrList3 = arrayListOf<String>()
        arrList3.add("X")
        println(arrList3[0])
        val arrList4 = arrayListOf<Int>()
        // val arrList5 = ArrayList<String>("a","b") wrong
        val arrList5 = ArrayList<String>()
        arrList5.add("Y")
        println(arrList5[0])

        for (item in arr){
            println(item)
        }
        for (item in arr2){
            println(item)
        }
        for (item in arrList){
            println(item)
        }
        for (item in arrList2){
            println(item)
        }

        arrList.add(444)
        println(arrList[3])
        println(arr.size)
        println(arrList.size)

        val set = setOf<Int>(1,1,2,3,3) // takes distinct values
        println(set.size)
        println("---")
        set.forEach { println(it * 4) }

        println("----HASHMAPS----")
        // hashmap like arraylist map like set
        //val ageMap = HashMap<String, Int>()
        val ageMap = hashMapOf<String, Int>()
        ageMap["Ahmet"] = 21 // the same
        ageMap.set("Ecmel", 18) // the same
        ageMap.put("Ahmet1", 22)
        ageMap.put("Ecmel1", 19)
        ageMap.put("Ahmet2", 23) // the same
        ageMap.put("Ecmel2", 20) // the same

        val ageMap2 = hashMapOf<String, Int>("Ahmet" to 21, "Ecmel" to 18, "Ahmet1" to 22, "Ecmel1" to 19)

        for(item in ageMap){
            println("${item.key} : ${item.value}") // does not print in order
        }

        for(item in ageMap2){
            println("${item.key} : ${item.value}")
        }

        println("----FOR LOOPS----")
        for (i in 0..9){
            println(i)
        }
        for (i in 1..4){
            println(i)
        }
        for (i in 0 until 6 step 2) { // 6 not included
            println(i)
        }

        for (i in 9 downTo 0 step 3) { // 9 and 0 included
            println(i)
        }*/


        /*println(forceChoke());

        val list = ArrayList<String>()
        val list2: ArrayList<String> = ArrayList()

        val n: String? = null;
        //n = "a"; val immutable değişmez var mutable değişir
        println(n?.length)
        val len = n?.length ?: -1
        println(len)


        //val person: Person = Person();
        val car: Car;
        //car.make = "a";
        //person.age = 3;

        val u = User("Ahmet Yıldırım", "ahmet.zoothii@gmail.com")
        println(u)

        val printMessage = { message: String -> println(message) }
        printMessage("ahmet")*/

        /*// TODO ÖNEMLİ KISIM GİBİ
        fun downloadData(url: String, completion: () -> Unit) {
            // sent a download request
            // we got back data
            // there were no network errors
            completion() // bu bitince çalışır aşağıdaki
        }

        // call downloadData funciton
        downloadData(
            "fakerUrl.com",
            { println("the code in this block, will only run after completion()") })

        fun downloadCarData(url: String, completion: (Car) -> Unit) {
            // sent a download request
            // we got back data
            // there were no network errors
            val car = Car("Tesla", "ModelX")
            completion(car)
        }

        fun downloadCarData2(url: String, completion: (Car?, Boolean) -> Unit) {
            // sent a web request
            // we got back result
            // there were no network errors
            val webRequestSuccess = true
            if (webRequestSuccess){
                // received car data
                val car2 = Car("Tesla2", "ModelX2")
                completion(car2, true)
            }else{
                completion(null, false)
            }
        }

        downloadCarData("fake.com") { car ->
            println(car.make)
            println(car.model)
        }

        downloadCarData("fake.com") { // dönüş 1 tane ise
            println(it.make)
            println(it.model)
        }

        downloadCarData2("fake.com") { car, success -> // dönüş 1 tane ise
            if (success){
                // do something with data
                println(car?.make)
                println(car?.model)
            }
            else{
                // handle request failure
                println("something went wrong")
            }


        }*/

    }

    /*private fun forceChoke(): String {
        return "a";
    }

    class Car constructor(make: String, model: String) {
        val make = make;
        val model = model;
    }

    class Person(
        val firstName: String,
        val lastName: String,
        var age: Int, // trailing comma
    ) { *//*...*//* }

    class Person2 {
        lateinit var firstName: String;

    }

    //class User constructor (_name: String, _email: String) {
    open class User(name: String, email: String) { // open to inheritance

        private val name = name
        private val email = email

        override fun toString(): String {

            return "User $name has email $email"
        }
    }*/

}