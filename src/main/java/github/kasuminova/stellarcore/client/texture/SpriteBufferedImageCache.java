package github.kasuminova.stellarcore.client.texture;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResource;
import org.apache.commons.io.IOUtils;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpriteBufferedImageCache {

    public static final SpriteBufferedImageCache INSTANCE = new SpriteBufferedImageCache();

    private final Map<TextureAtlasSprite, BufferedImage> cache = new ConcurrentHashMap<>();
    private final Map<TextureAtlasSprite, int[]> rgbCache = new ConcurrentHashMap<>();
    private final Map<TextureAtlasSprite, IResource> resourceCache = new ConcurrentHashMap<>();

    public BufferedImage getImage(TextureAtlasSprite sprite) {
        return cache.get(sprite);
    }

    public int[] getRGBAndRemove(TextureAtlasSprite sprite) {
        return rgbCache.remove(sprite);
    }

    public IResource getResourceAndRemove(TextureAtlasSprite sprite) {
        return resourceCache.remove(sprite);
    }

    public void put(TextureAtlasSprite sprite, IResource resource) {
        resourceCache.put(sprite, resource);
    }

    public void put(TextureAtlasSprite sprite, BufferedImage image, int[] rgbArr) {
        cache.put(sprite, image);
        rgbCache.put(sprite, rgbArr);
    }

    public void clear() {
        cache.clear();
        rgbCache.clear();
        resourceCache.values().forEach(IOUtils::closeQuietly);
        resourceCache.clear();
    }

}
