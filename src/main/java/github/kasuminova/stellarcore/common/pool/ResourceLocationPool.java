package github.kasuminova.stellarcore.common.pool;

import github.kasuminova.stellarcore.common.mod.Mods;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.fml.common.Optional;
import mirror.normalasm.api.NormalStringPool;

import javax.annotation.Nullable;
import java.util.Locale;
import java.util.function.Consumer;

public class ResourceLocationPool extends AsyncCanonicalizePoolBase<String> {

    public static final ResourceLocationPool INSTANCE = new ResourceLocationPool();

    private final Object2ObjectOpenHashMap<String, String> lowerCasePool = new Object2ObjectOpenHashMap<>();
    private volatile long processedCount = 0;

    private ResourceLocationPool() {
    }

    @Override
    public String canonicalize(@Nullable final String target) {
        if (target == null) {
            return null;
        }
        synchronized (lowerCasePool) {
            processedCount++;
            return lowerCasePool.computeIfAbsent(target, key -> {
                String value = key.toLowerCase(Locale.ROOT);
                if (Mods.CENSORED_ASM.loaded()) {
                    canonicalizeFromNormalStringPool(key, value);
                }
                return value;
            });
        }
    }

    @Override
    public void canonicalizeAsync(final String target, final Consumer<String> callback) {
        throw new UnsupportedOperationException("ResourceLocationPool does not supported yet.");
    }

    @Override
    public long getProcessedCount() {
        return processedCount;
    }

    @Override
    public int getUniqueCount() {
        return lowerCasePool.size();
    }

    @Override
    protected String getName() {
        return "ResourceLocationPool";
    }

    @Override
    public void clear() {
        synchronized (lowerCasePool) {
            processedCount = 0;
            lowerCasePool.clear();
        }
    }

    @Optional.Method(modid = "normalasm")
    protected void canonicalizeFromNormalStringPool(final String t, final String ret) {
        worker.offer(new CanonicalizeTask<>(() -> {
            String key = canonicalizeFromNormalStringPool(t);
            String value = canonicalizeFromNormalStringPool(ret);
            synchronized (lowerCasePool) {
                lowerCasePool.put(key, value);
            }
            // just a async task.
            return null;
        }, null));
    }

    @Optional.Method(modid = "normalasm")
    private static String canonicalizeFromNormalStringPool(final String target) {
        return NormalStringPool.canonicalize(target);
    }

}
