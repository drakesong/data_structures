public class Main {
	// Created by Professor Justin Li
    public static void main(String[] args) {
        Map map = new AVLTreeMap();
        map.put("doe", "A deer, a female deer.");
        map.put("ray", "A drop of golden sun.");
        map.put("me", "A name I call myself.");
        map.put("far", "A long long way to run.");
        map.put("ray", "Testing");
        System.out.println(map.size()); // 4
        System.out.println(map.get("ray")); // "A drop of golden sun."
    }
}
