package game;

public enum Textures {
	
}

//private static class Textures {
//    final BufferedImage regular;
//    final BufferedImage dark;
//
//    Textures(BufferedImage regular) {
//        this.regular = Objects.requireNonNull(regular,
//            "Image cannot be null");
//        this.dark = darken(regular);
//    }
//}
//
//private static final Map<TextureType, Textures> textures;
//
//static {
//    Map<TextureType, Textures> map = new EnumMap(TextureType.class);
//    for (TextureType type : TextureType.values()) {
//        map.put(type,
//            new Textures(renderer.loadImage(path + baseName + ".png")));
//    }
//
//    textures = Collections.unmodifiableMap(map);
//}
//
///** returns the textures of the name provided */
//public static BufferedImage getTexture(TextureType type, boolean darken) {
//    Objects.requireNonNull(type, "Texture type cannot be null");
//    Textures match = textures.get(type);
//    return darken ? match.dark : match.regular;
//}