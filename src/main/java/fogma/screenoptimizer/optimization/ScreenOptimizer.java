package fogma.screenoptimizer.optimization;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;


/*
TODO: Fix when entering chat it automatically presses the keybind for chat
 */


public class ScreenOptimizer {

    private static boolean PreviouslyInInventory = false;
//    private static boolean PreviouslyInChat = false;



    public static void start() {}




    public static void onFrame() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;




        boolean inv  = mc.options.keyInventory.isDown();
        boolean chat = mc.options.keyChat.isDown();





        if (inv && !PreviouslyInInventory) {
            drain(mc.options.keyInventory);
            if (mc.gui.screen() instanceof InventoryScreen) mc.player.closeContainer();
            else mc.gui.setScreen(new InventoryScreen(mc.player));
        }



//        if (chat && !PreviouslyInChat) {
//            drain(mc.options.keyChat);
//            if (mc.screen instanceof ChatScreen) mc.setScreen(null);
//            else mc.setScreen(new ChatScreen("", false));
//        }

        if (!inv)  drain(mc.options.keyInventory);
//       if (!chat) drain(mc.options.keyChat);

        PreviouslyInInventory = inv;
//        PreviouslyInChat = chat;
    }

    private static void drain(KeyMapping k) {
        while (k.consumeClick()) {}
    }
}