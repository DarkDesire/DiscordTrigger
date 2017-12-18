import utils.Discord

object Main extends App {
  sys.addShutdownHook(
    Discord.sendMessage("shutdown")
  )
  Discord.sendMessage("startup")
  Thread.sleep(5000L)
  sys.exit(0)
}