/*
fun main() {
    val call = ProcessRegistry().getServiceProcess("jvm")!!.constructors.firstOrNull()!!.call()

    call.start(
        object : ICloudService {
            override fun getId(): String {
                return UUID.randomUUID().toString()
            }

            override fun isStatic(): Boolean {
                return false
            }
        },
        command = "java"
    )
}
 */