package github.kasuminova.stellarcore.common.config;

import com.cleanroommc.configanytime.ConfigAnytime;
import github.kasuminova.stellarcore.StellarCore;
import github.kasuminova.stellarcore.client.model.ParallelModelLoaderAsyncBlackList;
import github.kasuminova.stellarcore.client.pool.StellarUnpackedDataPool;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;

@Mod.EventBusSubscriber(modid = StellarCore.MOD_ID)
@Config(modid = StellarCore.MOD_ID, name = StellarCore.MOD_ID)
public class StellarCoreConfig {

    @Config.Name("Debug")
    public static final Debug DEBUG = new Debug();

    @Config.Name("BugFixes")
    public static final BugFixes BUG_FIXES = new BugFixes();

    @Config.Name("Performance")
    public static final Performance PERFORMANCE = new Performance();

    @Config.Name("Features")
    public static final Features FEATURES = new Features();

    public static class Debug {

        @Config.Name("EnableDebugLog")
        public boolean enableDebugLog = false;

    }

    public static class BugFixes {

        @Config.Name("Vanilla")
        public final Vanilla vanilla = new Vanilla();

        @Config.Name("Critical")
        public final Critical critical = new Critical();

        @Config.Name("Container")
        public final Container container = new Container();

        @Config.Name("AdvancedRocketry")
        public final AdvancedRocketry advancedRocketry = new AdvancedRocketry();

        @Config.Name("AncientSpellCraft")
        public final AncientSpellCraft ancientSpellCraft = new AncientSpellCraft();

        @Config.Name("ArmourersWorkshop")
        public final ArmourersWorkshop armourersWorkshop = new ArmourersWorkshop();

        @Config.Name("AstralSorcery")
        public final AstralSorcery astralSorcery = new AstralSorcery();

        @Config.Name("Avaritaddons")
        public final Avaritaddons avaritaddons = new Avaritaddons();

        @Config.Name("Botania")
        public final Botania botania = new Botania();

        @Config.Name("CoFHCore")
        public final CoFHCore coFHCore = new CoFHCore();

        @Config.Name("CustomStartingGear")
        public final CustomStartingGear customStartingGear = new CustomStartingGear();

        @Config.Name("DraconicEvolution")
        public final DraconicEvolution draconicEvolution = new DraconicEvolution();

        @Config.Name("EnderIOConduits")
        public final EnderIOConduits enderIOConduits = new EnderIOConduits();

        @Config.Name("ExtraBotany")
        public final ExtraBotany extraBotany = new ExtraBotany();

        @Config.Name("FluxNetworks")
        public final FluxNetworks fluxNetworks = new FluxNetworks();

        @Config.Name("IndustrialCraft2")
        public final IndustrialCraft2 industrialCraft2 = new IndustrialCraft2();

        @Config.Name("InGameInfoXML")
        public final InGameInfoXML inGameInfoXML = new InGameInfoXML();

        @Config.Name("ImmersiveEngineering")
        public final ImmersiveEngineering immersiveEngineering = new ImmersiveEngineering();

        @Config.Name("JourneyMap")
        public final JourneyMap journeyMap = new JourneyMap();

        @Config.Name("LibVulpes")
        public final LibVulpes libVulpes = new LibVulpes();

        @Config.Name("Mekanism")
        public final Mekanism mekanism = new Mekanism();

        @Config.Name("ModularRouters")
        public final ModularRouters modularRouters = new ModularRouters();

        @Config.Name("MoreElectricTools")
        public final MoreElectricTools moreElectricTools = new MoreElectricTools();

        @Config.Name("MrCrayfishFurniture")
        public final MrCrayfishFurniture mrCrayfishFurniture = new MrCrayfishFurniture();

        @Config.Name("RPSIdeas")
        public final RPSIdeas rpsIdeas = new RPSIdeas();

        @Config.Name("ScalingGuis")
        public final ScalingGuis scalingGuis = new ScalingGuis();

        @Config.Name("Sync")
        public final Sync sync = new Sync();

        @Config.Name("TConEvo")
        public final TConEvo tConEvo = new TConEvo();

        @Config.Name("Techguns")
        public final Techguns techguns = new Techguns();

        @Config.Name("TheOneProbe")
        public final TheOneProbe theOneProbe = new TheOneProbe();

        @Config.Name("ThermalDynamics")
        public final ThermalDynamics thermalDynamics = new ThermalDynamics();

        @Config.Name("ThermalExpansion")
        public final ThermalExpansion thermalExpansion = new ThermalExpansion();

        public static class Vanilla {

            @Config.Comment({
                    "Unlocks the size limit of NBT and removes the length limit of NBTTagCompound and NBTTagList,",
                    "usually many mods will have this feature, you just need to enable one of these modules."
            })
            @Config.RequiresMcRestart
            @Config.Name("LongNBTKiller")
            public boolean longNBTKiller = false;

            @Config.Comment({
                    "The maximum depth of NBTTagCompound and NBTTagList.", 
                    "It will only take effect if LongNBTKiller is enabled."
            })
            @Config.Name("MaxNBTDepth")
            public int maxNBTDepth = 2048;

            @Config.Comment({
                    "The maximum size of NBT.",
                    "It will only take effect if LongNBTKiller is enabled."
            })
            @Config.Name("MaxNBTSize")
            public int maxNBTSize = 1024 * 1024 * 2 * 8;

            @Config.Comment({
                    "If the NBT size is larger than the maximum size, it will display a warning message.",
                    "It will only take effect if LongNBTKiller is enabled."
            })
            @Config.Name("DisplayLargeNBTWarning")
            public boolean displayLargeNBTWarning = true;

        }

        public static class Critical {

            @Config.Comment("Usually just set it to true, this option fixed a serious network packet problem.")
            @Config.Name("GuGuUtilsSetContainerPacket")
            public boolean guguUtilsSetContainerPacket = true;

        }

        public static class Container {

            @Config.Comment({
                    "A generic feature that when a player's open TileEntity GUI is uninstalled, ",
                    "it also forces the player's open GUI to be closed."
            })
            @Config.Name("ContainerUnloadTileEntityFixes")
            public boolean containerTileEntityFixes = false;

        }

        public static class AdvancedRocketry {

            @Config.Comment("Fix the NPE problem that occasionally occurs with BiomeChanger.")
            @Config.Name("ItemBiomeChanger")
            public boolean itemBiomeChanger = true;

            @Config.Comment({
                    "When the planetDefs.xml file is corrupted, make it regenerate the file instead of letting it damn near crash.",
                    "This is usually only a problem if the game process is unexpectedly exited, and the file is usually unrecoverable without a backup."
            })
            @Config.Name("PreventDimensionManagerCrash")
            public boolean dimensionManager = true;

        }

        public static class AncientSpellCraft {

            @Config.Comment({
                    "(Client Only) Fix a memory leak caused by AncientSpellCraft's FakePlayer,",
                    "mainly in that it would cause the first world loaded not to be cleaned up by Java GC.",
                    "Experimental, if a crash occurs with anything related to ASFakePlayer, please report this issue immediately."
            })
            @Config.Name("ASFakePlayerFixes")
            public boolean asFakePlayer = false;

        }

        public static class ArmourersWorkshop {

            @Config.Comment("Cleanroom only, used to fix an issue that caused the game to crash when unloading skin texture files.")
            @Config.Name("SkinTextureCrashFixes")
            public boolean skinTexture = true;

        }

        public static class AstralSorcery {

            @Config.Comment("This option is used to fix occasional crashes related to PlayerAttributeMap.")
            @Config.RequiresWorldRestart
            @Config.Name("PlayerAttributeMapCrashFixes")
            public boolean playerAttributeMap = true;

            @Config.Comment("This option is used to fix some item duplication issues on Astral Tome's constellation paper collection page.")
            @Config.Name("ContainerJournalFixes")
            public boolean containerJournal = true;

        }

        public static class Avaritaddons {

            @Config.Comment("This option is used to fix some item duplication issues with Auto Extreme Crafting Table.")
            @Config.Name("TileEntityExtremeAutoCrafterFixes")
            public boolean tileEntityExtremeAutoCrafter = true;

        }

        public static class Botania {

            @Config.Comment("(Client Only) Automatically clean up data when the player switches worlds, optional feature as WeakHashMap does not usually cause memory leaks.")
            @Config.Name("AutoCleanManaNetworkHandler")
            public boolean manaNetworkHandler = true;

        }

        public static class CoFHCore {

            @Config.Comment("This option is used to fix some item duplication issues with any containers related to TE5.")
            @Config.Name("ContainerInventoryItemFixes")
            public boolean containerInventoryItem = true;

            @Config.Comment({
                    "This option is used to fix an issue that would accidentally cause non-stackable items to",
                    " exceed their maximum number of stacks."
            })
            @Config.Name("TileInventoryFixes")
            public boolean tileInventory = true;

        }

        public static class CustomStartingGear {

            @Config.Comment({
                    "This option causes CustomStartingGear to standardize the encoding of file reads to UTF-8,",
                    "preventing them from having problems on computers in certain regions."
            })
            @Config.Name("DataManagerCharSetFixes")
            public boolean dataManager = true;

        }

        public static class DraconicEvolution {

            @Config.Comment("This option is used to fix some item duplication issues with CraftingInjector.")
            @Config.Name("CraftingInjectorFixes")
            public boolean craftingInjector = true;

        }

        public static class EnderIOConduits {

            @Config.Comment({
                    "A somewhat disruptive feature fix that modifies some of the way item conduits work,",
                    "allowing some special cases to store extracted items inside the conduit,",
                    "which will help fix some item duplication issues,",
                    "but may introduce a slight performance overhead and some unexpected filter issues."
            })
            @Config.Name("ItemConduitItemStackCache")
            public boolean cachedItemConduit = false;

        }

        public static class ExtraBotany {

            @Config.Comment("Prevents the Mana Liquefaction Device from storing far more liquid magic than it is set to store.")
            @Config.Name("TileManaLiquefactionFixes")
            public boolean tileManaLiquefaction = true;

        }

        public static class FluxNetworks {

            @Config.Comment("Fixes an issue where TheOneProbe on a dedicated server shows localized text anomalies.")
            @Config.Name("TheOneProbeIntegration")
            public boolean fixTop = true;

            @Config.Comment("Possible fix for duplicate users or even crashes on player networks in some cases.")
            @Config.Name("SynchronizeFixes")
            public boolean synchronize = true;

        }

        public static class IndustrialCraft2 {

            @Config.Comment("Fixed an issue where some item repair recipes would duplication items.")
            @Config.Name("GradualRecipeFixes")
            public boolean gradualRecipe = true;

            @Config.Comment("Fixed an issue where the orientation determined by Ejector / Pulling Upgrade was the opposite of what it actually was.")
            @Config.Name("StackUtilInvFacingFixes")
            public boolean stackUtilInvFacingFixes = true;

        }

        public static class InGameInfoXML {

            @Config.Comment("Fix the issue where a paragraph would pop up to report an error in a server environment, that's all.")
            @Config.Name("PlayerHandlerFixes")
            public boolean playerHandler = true;

        }

        public static class ImmersiveEngineering {

            @Config.Comment("Fixes an issue that would cause items to duplicate in certain special cases, although they were a bit tricky to reproduce.")
            @Config.Name("MultiblockStructureContainerFixes")
            public boolean blockIEMultiblock = true;

            @Config.Comment("Fixes an issue that would cause fluids to duplicate in some special cases, although they were a bit tricky to reproduce.")
            @Config.Name("JerryCanFixes")
            public boolean fixJerryCanRecipe = true;

            @Config.Comment("Makes Excavator not drop twice drops when digging blocks (possible side effect).")
            @Config.Name("TileEntityExcavatorDigBlockFixes")
            public boolean tileEntityExcavator = true;

            @Config.Comment({
                    "Fixes an issue that caused ArcFurnace's item bar items to stack",
                    "more than their items themselves under certain special circumstances, helping to fix item duplication."
            })
            @Config.Name("TileEntityArcFurnaceInventoryFixes")
            public boolean tileEntityArcFurnace = true;

            @Config.Comment({
                    "(Client Only) Clear the model cache when the player switches worlds to avoid memory leaks.",
                    "Minor performance impact. Mainly a problem when installing with other mods."
            })
            @Config.Name("AutoCleanRenderCache")
            public boolean renderCache = true;

            @Config.Comment({
                    "Immediately exit the thread when `Immersive Engineering Contributors Thread` encounters an error while reading JSON,",
                    "instead of always printing the error."
            })
            @Config.Name("IEContributorsThreadExceptionFixes")
            public boolean contributorSpecialsDownloader = true;

        }

        public static class JourneyMap {

            @Config.Comment("(Client Only) Automatically clears the radar player cache when a player switches worlds to avoid memory leaks caused in the client.")
            @Config.Name("AutoCleanPlayerRadar")
            public boolean playerRadar = true;

        }

        public static class LibVulpes {

            @Config.Comment({
                    "(Client Only) Automatically clean up InputSyncHandler's spaceDown data when the player switches worlds.",
                    "Although libvulpes has already coded this judgment, there is still a small chance that it will trigger a memory leak."
            })
            @Config.Name("AutoCleanInputSyncHandlerData")
            public boolean inputSyncHandler = true;

        }

        public static class Mekanism {

            @Config.Comment({
                    "(Client Only) Automatically clean up old player data when the player switches worlds to address some memory leaks,",
                    "and while Mekanism has written cleanup features, they will only clean up when returning to the main menu."
            })
            @Config.Name("AutoCleanPortableTeleports")
            public boolean portableTeleports = true;

        }

        public static class ModularRouters {

            @Config.Comment("Prevent routers from recognizing fluid bucket containers to avoid unexpected fluid replication problems.")
            @Config.Name("BufferHandlerFluidHandlerFixes")
            public boolean bufferHandler = true;

        }

        public static class MoreElectricTools {

            @Config.Comment("Items such as Electric First Aid Life Support do not continue to work if the player has died.")
            @Config.Name("LifeSupportsFixes")
            public boolean fixLifeSupports = true;

        }

        public static class MrCrayfishFurniture {

            @Config.Comment("Stops the game from freezing in certain special cases, mainly occurring on photo frames and other similar blocks.")
            @Config.RequiresMcRestart
            @Config.Name("ImageCacheCrashFixes")
            public boolean imageCache = true;

            @Config.Comment("Make blocks be rotated without losing their internal attributes and items (possibly not all blocks).")
            @Config.Name("RotatableFurniture")
            public boolean rotatableFurniture = false;

            @Config.Comment("Problem preventing certain container items from duplicate.")
            @Config.Name("BlockFurnitureTileFixes")
            public boolean blockFurnitureTile = true;

            @Config.Comment("Stopping washing machines from repairing non-repairable items.")
            @Config.Name("WashingMachineDamageFixes")
            public boolean washingMachine = true;

        }

        public static class RPSIdeas {

            @Config.Comment("(Client Only) Fix memory leaks caused by improper object management on the client side.")
            @Config.Name("ItemBioticSensorMemoryLeakFixes")
            public boolean itemBioticSensor = true;

        }

        public static class ScalingGuis {

            @Config.Comment("Fixes an issue that caused a crash when deleting invalid GUI configurations.")
            @Config.Name("JsonHelperCrashFixes")
            public boolean fixJsonHelper = true;

        }

        public static class Sync {

            @Config.Comment("A special fix that keeps Sync from triggering some weird item duplication issues when installed with Techguns.")
            @Config.Name("TechgunsDuplicationFixes")
            public boolean techgunsDuplicationFixes = true;

            @Config.Comment("Make players get off their mounts when they die.")
            @Config.Name("RidingFixes")
            public boolean ridingFixes = true;

        }

        public static class TConEvo {

            @Config.Comment({
                    "Fix a special crash issue that would cause special cases,",
                    "reporting that they were attributed to xyz.phanta.tconevo.integration.avaritia.client.AvaritiaMaterialModel$BakedAvaritiaMaterialModel$ WithoutHalo handleCosmicLighting()."
            })
            @Config.Name("HandleCosmicLightingNPEFixes")
            public boolean handleCosmicLightingNPEFixes = true;

        }

        public static class Techguns {

            @Config.Comment("Fixes an issue that would cause crashes in server environments.")
            @Config.Name("TGPermissionsCrashFixes")
            public boolean tgPermissions = true;

            @Config.Comment("Fix for recipes not working properly for certain items (Techguns only).")
            @Config.Name("InvalidRecipeFixes")
            public boolean fixAmmoSumRecipeFactory = true;

            @Config.Comment("Fixes an issue that would cause crashes in server environments.")
            @Config.Name("ServerSideEntityCrashFixes")
            public boolean serverSideEntityCrashFixes = true;

        }

        public static class TheOneProbe {

            @Config.Comment("Prevents TheOneProbe from rendering the entity/player in such a way that their head is locked to a fixed pitch.")
            @Config.Name("PlayerEntityRenderFixes")
            public boolean fixRenderHelper = true;

        }

        public static class ThermalDynamics {

            @Config.Comment("Fix a fluid duplication issue where they would only appear on Super-Laminar FluidDuct.")
            @Config.Name("FluidDuplicateFixes")
            public boolean fixFluidDuplicate = true;

        }

        public static class ThermalExpansion {

            @Config.Comment("The problem with stopping a backpack from replicating is that this probably does the same thing as UniversalTweaks.")
            @Config.Name("ContainerSatchelFilterFixes")
            public boolean containerSatchelFilter = true;

        }

    }

    public static class Performance {

        @Config.Name("Vanilla")
        public final Vanilla vanilla = new Vanilla();

        @Config.Name("Forge")
        public final Forge forge = new Forge();

        @Config.Name("AstralSorcery")
        public final AstralSorcery astralSorcery = new AstralSorcery();

        @Config.Name("Avaritia")
        public final Avaritia avaritia = new Avaritia();

        @Config.Name("BiomesOPlenty")
        public final BiomesOPlenty biomesOPlenty = new BiomesOPlenty();

        @Config.Name("EnderUtilities")
        public final EnderUtilities enderUtilities = new EnderUtilities();

        @Config.Name("ExtraBotany")
        public final ExtraBotany extraBotany = new ExtraBotany();

        @Config.Name("BloodMagic")
        public final BloodMagic bloodMagic = new BloodMagic();

        @Config.Name("Botania")
        public final Botania botania = new Botania();

        @Config.Name("Chisel")
        public final Chisel chisel = new Chisel();

        @Config.Name("CTM")
        public final CTM ctm = new CTM();

        @Config.Name("Cucumber")
        public final Cucumber cucumber = new Cucumber();

        @Config.Name("CustomLoadingScreen")
        public final CustomLoadingScreen customLoadingScreen = new CustomLoadingScreen();

        @Config.Name("EBWizardry")
        public final EBWizardry ebWizardry = new EBWizardry();

        @Config.Name("EnderCore")
        public final EnderCore enderCore = new EnderCore();

        @Config.Name("EnderIO")
        public final EnderIO enderIO = new EnderIO();

        @Config.Name("EnderIOConduits")
        public final EnderIOConduits enderIOConduits = new EnderIOConduits();

        @Config.Name("FluxNetworks")
        public final FluxNetworks fluxNetworks = new FluxNetworks();

        @Config.Name("FTBLib")
        public final FTBLib ftbLib = new FTBLib();

        @Config.Name("FTBQuests")
        public final FTBQuests ftbQuests = new FTBQuests();

        @Config.Name("IndustrialCraft2")
        public final IndustrialCraft2 industrialCraft2 = new IndustrialCraft2();

        @Config.Name("InGameInfoXML")
        public final InGameInfoXML inGameInfoXML = new InGameInfoXML();

        @Config.Name("ImmersiveEngineering")
        public final ImmersiveEngineering immersiveEngineering = new ImmersiveEngineering();

        @Config.Name("LibNine")
        public final LibNine libNine = new LibNine();

        @Config.Name("Mekanism")
        public final Mekanism mekanism = new Mekanism();

        @Config.Name("TConstruct")
        public final TConstruct tConstruct = new TConstruct();

        @Config.Name("TouhouLittleMaid")
        public final TouhouLittleMaid tlm = new TouhouLittleMaid();

        public static class Vanilla {

            @Config.Comment({
                    "(Client Performance | Experimental) A feature from Patcher mod, using protocol CC-BY-NC-SA 4.0, if there are any copyright issues, please contact me to remove it." ,
                    "Dramatically improves performance by limiting the HUD to a specified FPS, may not be compatible with older devices." ,
                    "May perform strangely with some HUD Mods."
            })
            @Config.RequiresMcRestart
            @Config.Name("HudCaching")
            public boolean hudCaching = false;

            @Config.Comment("Select a restricted HUD FPS that is only valid when HudCaching is enabled.")
            @Config.RangeInt(min = 5, max = 240)
            @Config.Name("HudCachingFPSLimit")
            public int hudCachingFPSLimit = 20;

            @Config.Comment({
                    "(Client Performance | Experimental) A feature that helps speed up game loading by modifying the model loader's code to enable parallel loading capabilities (5s ~ 40s faster).",
                    "Incompatible with some mod's models because they use their own model loader, if you encounter a missing model, please report it to the StellarCore author for manual compatibility.",
                    "Compatible model loader: CTM，LibNine，TConstruct",
                    "Contrary to VintageFix's DynamicResource functionality and therefore incompatible, you can only choose one."
            })
            @Config.RequiresMcRestart
            @Config.Name("ParallelModelLoader")
            public boolean parallelModelLoader = true;

            @Config.Comment({
                    "(Client Performance) Clearing the cache after loading a model, significantly reduce memory usage.",
                    "But it may cause some mod's models to be messed up after reloading ResourcePacks,",
                    "Turning this option off will use more memory.",
                    "If you installed FoamFix, FoamFix does the same thing but StellarCore is faster, you may need to turn off the `wipeModelCache` option in foamfix.cfg."
            })
            @Config.RequiresMcRestart
            @Config.Name("WipeModelCache")
            public boolean wipeModelCache = true;

            @Config.Comment({
                    "Defining which ModelLoader cannot be safely asynchronized to allow StellarCore to load models",
                    "using a synchronous approach, usually requires no modification to it."
            })
            @Config.RequiresMcRestart
            @Config.Name("ParallelModelLoaderBlackList")
            public String[] parallelModelLoaderBlackList = {"slimeknights.tconstruct.library.client.model.ModifierModelLoader"};

            @Config.Comment({
                    "(Client Performance | Experimental) An feature that uses parallel loading of texture files, improved game loading speed.",
                    "If you get a crash when installing with VintageFix, turn this feature off, or turn off the mixins.texturemap option for VintageFix."
            })
            @Config.RequiresMcRestart
            @Config.Name("ParallelTextureLoad")
            public boolean parallelTextureLoad = false;

            @Config.Comment("(Client Performance) Improve the Map data structures of StateMapperBase to make them faster (~30%).")
            @Config.RequiresMcRestart
            @Config.Name("StateMapperBaseImprovements")
            public boolean stateMapperBase = true;

            @Config.Comment("(Server Performance) Modified the data structure of capturedBlockSnapshots to a LinkedList to help improve insertion and deletion performance.")
            @Config.RequiresMcRestart
            @Config.Name("CapturedBlockSnapshotsImprovements")
            public boolean capturedBlockSnapshots = false;

            @Config.Comment({
                    "(Client/Server Performance) Use long instead of BlockPos to store TileEntities, optimising memory usage and potentially improving performance.",
                    "Conflicts with UniversalTweaks - 'Tile Entity Map' options and StellarCore maybe overrides them."
            })
            @Config.RequiresMcRestart
            @Config.Name("ChunkTileEntityMapImprovements")
            public boolean blockPos2ValueMap = false;

            @Config.Comment("(Server Performance) Improving the performance of ClassInheritanceMultiMap (up to ~40%).")
            @Config.RequiresMcRestart
            @Config.Name("ClassInheritanceMultiMapImprovements")
            public boolean classMultiMap = true;

            @Config.Comment("(Server Performance) Improving EntityTracker Performance with Improved Data Structures.")
            @Config.RequiresMcRestart
            @Config.Name("EntityTrackerImprovements")
            public boolean entitytracker = true;

            @Config.Comment("(Server Performance) Improving WorldServer#getPendingBlockUpdates Performance with Improved Data Structures.")
            @Config.RequiresMcRestart
            @Config.Name("WorldServerGetPendingBlockUpdatesImprovements")
            public boolean worldServerGetPendingBlockUpdates = true;

            @Config.Comment("(Client Performance) Improving PropertyEnum#hashCode Performance with hashCode cache.")
            @Config.RequiresMcRestart
            @Config.Name("PropertyEnumHashCodeCache")
            public boolean propertyEnumHashCodeCache = true;

            @Config.Comment("(Server Performance) Improving BlockStateContainer$BlockStateImplementation#hashCode Performance with hashCode cache.")
            @Config.RequiresMcRestart
            @Config.Name("BlockStateImplementationHashCodeCache")
            public boolean blockStateImplementationHashCodeCache = true;

            @Config.Comment({
                    "(Client/Server Performance) Improving NBTTagCompound Performance with Improved Data Structures.",
                    "Conflict with CensoredASM's `optimizeNBTTagCompoundBackingMap` and `nbtBackingMapStringCanonicalization` option."
            })
            @Config.RequiresMcRestart
            @Config.Name("NBTTagCompoundMapImprovements")
            public boolean nbtTagCompoundMap = true;

            @Config.Comment({
                    "(Client/Server Performance) Asynchronous loading of ItemStack's Capability to improve performance.",
                    "Conflict with CensoredASM's `delayItemStackCapabilityInit` option."
            })
            @Config.RequiresMcRestart
            @Config.Name("AsyncItemStackCapabilityInit")
            public boolean asyncItemStackCapabilityInit = true;

            @Config.Comment("(Client/Server Performance | Experimental) Replaces the internal default ArrayList of NonNullList with an ObjectArrayList (may not work).")
            @Config.RequiresMcRestart
            @Config.Name("NonNullListImprovements")
            public boolean nonNullList = true;

            @Config.Comment("(Client Performance) As the configuration name says, use at your own risk.")
            @Config.RequiresMcRestart
            @Config.Name("NoGLError")
            public boolean noGlError = false;

            @Config.Comment({
                    "(Client Performance | Sodium Feature) Making all immediate chunk updates always deferred helps improve intermittent ",
                    "low FPS conditions, but potentially leads to rendering delays."
            })
            @Config.RequiresMcRestart
            @Config.Name("AlwaysDeferChunkUpdates")
            public boolean alwaysDeferChunkUpdates = false;

            @Config.Comment({
                    "(Client Performance) Enabling Stitcher caching improves the game loading speed.",
                    "The main principle is to cache the Stitcher's splicing results and save them to the hard drive for next time reading, so",
                    "you need to pre-launch the game once before you can see the effect.",
                    "Not compatible with VintageFix's DynamicResource, but should work well with VintageFix's TurboStitcher."
            })
            @Config.RequiresMcRestart
            @Config.Name("StitcherCache")
            public boolean stitcherCache = false;

            @Config.Comment({
                    "(Client Performance) Caches the state of existence of each resource file in the ResourcePack,",
                    "improve the speed of model loading, if you encounter the game can not be loaded or display anomaly, turn off this option."
            })
            @Config.RequiresMcRestart
            @Config.Name("ResourceExistStateCache")
            public boolean resourceExistStateCache = true;

            @Config.Comment({
                    "(Client/Server Performance) Use parallelStream to handle randomTick operations on world blocks to improve performance in more player environments,",
                    "possibly affecting the random logic of the original game."
            })
            @Config.RequiresMcRestart
            @Config.Name("ParallelRandomBlockTicker")
            public boolean parallelRandomBlockTicker = false;

            @Config.Comment("(Client/Server Performance) Improved `World#isValid` / `World#isOutsideBuildHeight` judgement performance, minor performance improvements.")
            @Config.RequiresMcRestart
            @Config.Name("WorldBlockPosJudgement")
            public boolean worldBlockPosJudgement = true;

            @Config.RequiresMcRestart
            @Config.Comment("(Client Performance) Improved BlockPart data structure, improve memory usage with a more efficient map.")
            @Config.Name("BlockPartDataStructureImprovements")
            public boolean blockPartDataStructure = true;

            @Config.RequiresMcRestart
            @Config.Comment({
                    "(Client Performance) Modify the data structure of ModelBlock's textures map to improve performance and reduce memory usage.",
                    "This feature requires CensoredASM mod.",
                    "Known to be incompatible with DynamicTrees."
            })
            @Config.Name("ModelBlockStringCanonicalization")
            public boolean modelBlockStringCanonicalization = false;

            @Config.Comment({
                    "(Client Performance | Experimental) Deduplicate vertexData array to optimise memory usage.",
                    "Works in most cases, but may cause rendering issues with models in some mods."
            })
            @Config.RequiresMcRestart
            @Config.Name("BakedQuadVertexDataCanonicalization")
            public boolean bakedQuadVertexDataCanonicalization = false;

            @Config.Comment({
                    "(Client Performance | Experimental) BakedQuad deduplication of SimpleBakedModel to optimise memory usage.",
                    "Works in most cases, but may cause rendering issues with models in some mods."
            })
            @Config.RequiresMcRestart
            @Config.Name("SimpleBakedModelCanonicalization")
            public boolean simpleBakedModelCanonicalization = false;

            @Config.Comment("(Client Performance) Deduplicate BlockFaceUV `uvs` array to optimise memory usage.")
            @Config.RequiresMcRestart
            @Config.Name("BlockFaceUVsCanonicalization")
            public boolean blockFaceUVsCanonicalization = true;

            @Config.Comment({
                    "(Client Performance) Deduplicate internal strings of ResourceLocation to reduce memory usage.",
                    "When installed with CensoredASM, turn off the `resourceLocationCanonicalization` feature of CensoredASM.",
                    "StellarCore already has backend integration for it."
            })
            @Config.RequiresMcRestart
            @Config.Name("ResourceLocationCanonicalization")
            public boolean resourceLocationCanonicalization = true;

        }

        public static class Forge {

            @Config.Comment({
                    "(Client/Server Performance) ASMDataTable Annotation Map builds use half of the CPU instead of all of it,",
                    "helping to improve the computer freezing problem at game startup, but potentially causing the game to take longer to load."
            })
            @Config.RequiresMcRestart
            @Config.Name("ASMDataTableCPUUsageImprovements")
            public boolean asmDataTable = false;

            @Config.Comment({
                    "(Client Performance | Experimental) Deduplicate unpackedData array to optimise memory usage, with significant optimisation for some mods.",
                    "Works in most cases, but may cause rendering issues with models in some mods."
            })
            @Config.RequiresMcRestart
            @Config.Name("UnpackedBakedQuadDataCanonicalization")
            public boolean unpackedBakedQuadDataCanonicalization = false;

            @Config.Comment({
                    "Adjust the optimisation level of the `UnpackedBakedQuadDataCanonicalization` option, the higher the level",
                    "the better the results but the higher the probability of encountering problems, normally a setting of 2 is sufficient...",
                    "Higher levels consume more CPU performance.",
                    "This option can be adjusted while the game is running, but restarting the game is highly recommended."
            })
            @Config.SlidingOption
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 1, max = 3)
            @Config.Name("UnpackedBakedQuadDataCanonicalizationLevel")
            public int unpackedBakedQuadDataCanonicalizationLevel = 1;

            @Config.Comment({
                    "(Client Performance | Experimental) Deduplicate vertexData array to optimise memory usage.",
                    "Works in most cases, but may cause rendering issues with models in some mods."
            })
            @Config.RequiresMcRestart
            @Config.Name("UnpackedBakedQuadVertexDataCanonicalization")
            public boolean unpackedBakedQuadVertexDataCanonicalization = false;

        }

        public static class AstralSorcery {

            @Config.Comment("(Server Performance) Add optional updates to the block to improve network bandwidth usage.")
            @Config.Name("TileNetworkSkyboundImprovements")
            public boolean tileNetworkSkybound = true;

        }

        public static class Avaritia {

            @Config.Comment("(Server Performance) Removing some unnecessary Server to Client synchronization helps ease network bandwidth usage.")
            @Config.Name("TileBaseImprovements")
            public boolean tileBase = true;

            @Config.Comment("(Client / Server Performance) Speed up recipe loading with parallel loading.")
            @Config.Name("AvaritiaRecipeManagerImprovements")
            public boolean avaritiaRecipeManager = true;

        }

        public static class BiomesOPlenty {

            @Config.Comment("(Client/Server Performance) Block them from doing network operations in the main thread.")
            @Config.Name("TrailManagerAsync")
            public boolean trailManager = true;

        }

        public static class Cucumber {

            @Config.Comment("(Client/Server Performance) Block them from doing network operations in the main thread.")
            @Config.Name("VanillaPacketDispatcherImprovements")
            public boolean vanillaPacketDispatcher = false;

            @Config.Comment({
                    "When a block is updated, how many players within range can receive its update?",
                    "Only works if VanillaPacketDispatcherImprovements is enabled, and only works on mods that use the Cucumber lib."
            })
            @Config.Name("TileEntityUpdateRange")
            public float tileEntityUpdateRange = 16F;

        }

        public static class EnderUtilities {

            @Config.Comment("(Server Performance) Improvements to the way UtilItemModular loads items to slightly improve performance.")
            @Config.Name("UtilItemModularImprovements")
            public boolean utilItemModular = true;

        }

        public static class ExtraBotany {

            @Config.Comment("(Client/Server Performance) Block them from doing network operations in the main thread.")
            @Config.Name("PersistentVariableHandlerAsync")
            public boolean persistentVariableHandler = true;

        }

        public static class BloodMagic {

            @Config.Comment("(Server Performance) Removing some unnecessary Server to Client synchronization helps ease network bandwidth usage.")
            @Config.Name("BloodAltarImprovements")
            public boolean bloodAltar = true;

        }

        public static class Botania {

            @Config.Comment("(Server Performance) A feature with some side effects to make sparks use less performance through dynamic Tick acceleration.")
            @Config.Name("SparkEntityImprovements")
            public boolean sparkImprovements = false;

            @Config.Comment({
                    "What is the maximum working interval of the sparks? They will eventually be accelerated to 1 tick.",
                    "Only works if SparkEntityImprovements is enabled."
            })
            @Config.RangeInt(min = 2, max = 60)
            @Config.Name("SparkMaxWorkDelay")
            public int sparkMaxWorkDelay = 20;

        }

        public static class Chisel {

            @Config.Comment({
                    "(Server Performance) A feature with some side effects that improves the performance of Auto Chisel's recipe search",
                    "and makes the interval between searches for recipes increase."
            })
            @Config.Name("AutoChiselImprovements")
            public boolean autoChiselImprovements = true;

            @Config.Comment({
                    "What is the maximum recipe search interval of the Auto Chisels? They will eventually be accelerated to 20 tick.",
                    "Only works if AutoChiselImprovements is enabled."
            })
            @Config.RangeInt(min = 20, max = 100)
            @Config.Name("AutoChiselMaxWorkDelay")
            public int autoChiselMaxWorkDelay = 100;

        }
        
        public static class CTM {

            @Config.Comment({
                    "(Client Performance | Experimental) A feature that loads CTM's Metadata data faster (~60%) using parallelStream,",
                    "usually with few conflict issues. If enabling this feature causes a problem, please report it immediately."
            })
            @Config.RequiresMcRestart
            @Config.Name("TextureMetadataHandlerImprovements")
            public boolean textureMetadataHandler = false;

        }

        public static class CustomLoadingScreen {

            @Config.Comment("(Client Performance) Clean up their mapping after the game has finished loading to improve memory usage.")
            @Config.RequiresMcRestart
            @Config.Name("TextureCleanup")
            public boolean splashProgress = true;

            @Config.Comment("(Recommend) (Client Performance) We'll never know why we have to wait an extra (20*5)ms for each module loaded.")
            @Config.RequiresMcRestart
            @Config.Name("ModLoadingListenerImprovements")
            public boolean modLoadingListener = true;

        }

        public static class EBWizardry {

            @Config.Comment({
                    "(Server Performance) Improved event listening performance for DispenserCastingData.",
                    "Note: We are currently experiencing strange issues on some devices during testing, please report any unknown crashes with this feature enabled immediately."
            })
            @Config.Name("DispenserCastingDataImprovements")
            public boolean dispenserCastingData = false;

        }

        public static class EnderCore {

            @Config.Comment({
                    "(Server Performance) Improve the speed of matching materials such as items using caching and special data structures",
                    "to improve the performance of EnderIO Machines overall, with a slight increase in memory usage."
            })
            @Config.Name("ThingsImprovements")
            public boolean things = true;

            @Config.Comment({
                    "(Server Performance) Improve the speed of matching materials such as items using caching and special data structures",
                    "to improve the performance of EnderIO Machines overall, with a slight increase in memory usage."
            })
            @Config.Name("OreThingImprovements")
            public boolean oreThing = true;

        }

        public static class EnderIO {

            @Config.Comment("(Server Performance) Removing some unnecessary parts to improve performance, may affect the use of the Profiler.")
            @Config.Name("ItemToolsImprovements")
            public boolean itemTools = true;

            @Config.Comment("(Server Performance) Remove some unnecessary judgments to improve performance (may have side effects).")
            @Config.Name("TileEntityBaseImprovements")
            public boolean tileEntityBase = true;

            @Config.Comment("(Server Performance) Improve recipe search speed with caching.")
            @Config.Name("RecipeImprovements")
            public boolean recipe = true;

            @Config.Comment("(Server Performance) Improve the performance of item determination in FarmerStation using caching (mainly related to the canPlant() method).")
            @Config.Name("FarmerImprovements")
            public boolean commune = true;

        }

        public static class EnderIOConduits {

            @Config.Comment("(Server Performance) Removing some unnecessary parts to improve performance, may affect the use of the Profiler.")
            @Config.Name("AbstractConduitImprovements")
            public boolean abstractConduit = true;

            @Config.Comment("(Server Performance) Removing some unnecessary parts to improve performance, may affect the use of the Profiler.")
            @Config.Name("TileConduitBundleImprovements")
            public boolean tileConduitBundle = true;

            @Config.Comment("(Server Performance) Improved the hashCode() method of NetworkTankKey, which can improve the performance of the EnderIO Conduit Network.")
            @Config.Name("NetworkTankKeyHashCodeCache")
            public boolean networkTankKeyHashCodeCache = true;

            @Config.Comment("(Server Performance) Improved some data structures, slight performance improvements.")
            @Config.Name("EnderLiquidConduitNetworkTankMap")
            public boolean enderLiquidConduitNetworkTankMap = true;

            @Config.Comment("(Server Performance | Experimental) Rewriting the eio conduit energy network computation logic to improve performance using multithreading.")
            @Config.Name("NetworkPowerManagerImprovements")
            public boolean networkPowerManager = true;

        }

        public static class FluxNetworks {

            @Config.Comment("(Server Performance | Experimental) Rewriting the flux network calculation logic to improve performance using multithreading.")
            @Config.Name("ParallelNetworkCalculation")
            public boolean parallelNetworkCalculation = false;

            @Config.Comment("(Server Performance) Removing the secondary judgement of energy transfer may help improve performance.")
            @Config.Name("ConnectionTransferImprovements")
            public boolean connectionTransfer = true;

        }

        public static class FTBLib {

            @Config.Comment("(Server Performance) Improved some of the judgments so that it doesn't consume a lot of time sending network packets.")
            @Config.Name("InvUtilsForceUpdateImprovements")
            public boolean invUtilForceUpdate = true;

        }

        public static class FTBQuests {

            @Config.Comment("(Server Performance) Improved performance of item quest checking (but may result in longer intervals between quest checks).")
            @Config.Name("QuestInventoryListenerImprovements")
            public boolean questInventoryListener = false;

        }

        public static class IndustrialCraft2 {

            @Config.RequiresMcRestart
            @Config.Comment("(Server Performance | Experimental) Rewriting the ic2 energy network computation logic to improve performance using multithreading.")
            @Config.Name("EnergyCalculatorLegImprovements")
            public boolean energyCalculatorLeg = true;

            @Config.Comment("(Server Performance) Improved some data structures, slight performance improvements.")
            @Config.Name("GridDataImprovements")
            public boolean energyCalculatorLegGridData = true;

            @Config.Comment("(Server Performance) Improved some data structures, slight performance improvements.")
            @Config.Name("EnergyNetLocalImprovements")
            public boolean energyNetLocal = true;

            @Config.Comment("(Server Performance) Improve EnergyNetLocal#getIoTile and EnergyNetLocal#getSubTile fetching speed to optimise performance to some extent.")
            @Config.Name("GetIoAndSubTileEnergyNetLocalImprovements")
            public boolean getIoAndSubTile = true;

            @Config.Comment("(Server Performance) Improved some data structures, slight performance improvements.")
            @Config.Name("GridImprovements")
            public boolean grid = true;

            @Config.Comment("(Server Performance) Allows you to adjust the working speed of the Ejector / Pulling Module.")
            @Config.Name("ItemUpgradeModuleImprovements")
            public boolean itemUpgradeModule = false;

            @Config.Comment({
                    "Work speed of Ejector / Pulling Module.",
                    "Only works if ItemUpgradeModuleImprovements is enabled."
            })
            @Config.Name("ItemUpgradeModuleWorkDelay")
            public int itemUpgradeModuleWorkDelay = 5;

        }

        public static class InGameInfoXML {

            @Config.Comment({
                    "(Client Performance) Limit the rendering FPS of InGameInfoXML to significantly improve performance (similar to HUDCaching),",
                    "may not be compatible with older devices."
            })
            @Config.Name("HUDFramebuffer")
            public boolean hudFrameBuffer = false;

            @Config.Name("HUDFPS")
            @Config.Comment("Select a restricted HUD FPS that is only valid when HUDFramebuffer is enabled.")
            @Config.RangeInt(min = 5, max = 60)
            public int hudFrameRate = 10;

        }

        public static class ImmersiveEngineering {

            @Config.Comment({
                    "(Server Performance) Blocking the IE Mechanical Block from triggering a full block update when transferring energy may improve performance.",
                    "But if strange block states appear try turning off this option."
            })
            @Config.Name("EnergyTransferNoUpdate")
            public boolean energyTransferNoUpdate = true;

        }
        
        public static class LibNine {

            @Config.Comment({
                    "(Client Performance) Cache the result of L9Models#isOfType to improve game loading speed.",
                    "This feature requires Vanilla#ResourceExistStateCache option."
            })
            @Config.Name("L9ModelsIsOfTypeCache")
            public boolean l9ModelsIsOfTypeCache = true;

        }

        public static class Mekanism {

            @Config.Comment({
                    "(Server Performance) Performance improvements on data structures.",
                    "MEKCEu already includes this feature, so installing MEKCEu will automatically disable it."
            })
            @Config.Name("PipeUtilsImprovements")
            public boolean pipeUtils = true;

            @Config.Comment({
                    "(Server Performance) Performance improvements on data structures.",
                    "MEKCEu already includes this feature, so installing MEKCEu will automatically disable it."
            })
            @Config.Name("EnergyNetworkImprovements")
            public boolean energyNetwork = true;

            @Config.Comment({
                    "(Server Performance) Performance improvements on data structures.",
                    "MEKCEu already includes this feature, so installing MEKCEu will automatically disable it."
            })
            @Config.Name("FrequencyImprovements")
            public boolean frequency = true;

        }

        public static class TConstruct {

            @Config.Comment("(Server Performance) Improvements in the search performance of Melting recipes.")
            @Config.Name("MeltingRecipeSearchImprovements")
            public boolean meltingRecipeSearch = true;

            @Config.Comment("(Server Performance) Improvements in the search performance of Table Casing recipes.")
            @Config.Name("TableCastingRecipeSearchImprovements")
            public boolean tableCastingSearch = true;

            @Config.Comment("(Server Performance) Improvements in the search performance of Basin Casing recipes.")
            @Config.Name("BasinCastingRecipeSearchImprovements")
            public boolean basinCastingSearch = true;

            @Config.Comment("(Server Performance) Improvements in the search performance of Smeltery Alloy Casing recipes.")
            @Config.Name("TileSmelteryAlloyRecipeSearchImprovements")
            public boolean tileSmelteryAlloyRecipeSearch = true;

            @Config.Comment("(Server Performance) Smeltery What is the maximum number of recipes that can be completed per tick?")
            @Config.RangeInt(min = 1, max = 100)
            @Config.Name("TileSmelteryMaxAlloyRecipePerTick")
            public int tileSmelteryMaxAlloyRecipePerTick = 5;

        }

        public static class TouhouLittleMaid {

            @Config.Comment("(Client Performance) Enable model data Canonicalization to improve TLM model memory usage.")
            @Config.RequiresMcRestart
            public boolean modelDataCanonicalization = true;

            @Config.Comment("(Client Performance) Enable TexturedQuadFloat data Canonicalization to improve TLM model memory usage.")
            @Config.RequiresMcRestart
            public boolean texturedQuadFloatCanonicalization = true;

        }

    }

    public static class Features {

        @Config.Comment({
                "(Client) Allows you to modify the title of the game, highest priority, ",
                "supports earlier versions such as CleanroomLoader 3029 (May do the same thing with other mods)."
        })
        @Config.Name("EnableCustomGameTitle")
        public boolean enableTitle = false;

        @Config.Comment("Does the CustomGameTitle use Hitokoto API to get random messages? (Chinese Only)")
        @Config.Name("TitleUseHitokotoAPI")
        public boolean hitokoto = false;

        @Config.Comment("The title.")
        @Config.Name("CustomGameTitle")
        public String title = "Minecraft 1.12.2";

        @Config.Name("Vanilla")
        public final Vanilla vanilla = new Vanilla();

        @Config.Name("FontScale")
        public final FontScale fontScale = new FontScale();

        @Config.Name("AstralSorcery")
        public final AstralSorcery astralSorcery = new AstralSorcery();

        @Config.Name("BetterChat")
        public final BetterChat betterChat = new BetterChat();

        @Config.Name("Botania")
        public final Botania botania = new Botania();

        @Config.Name("EBWizardry")
        public final EBWizardry ebwizardry = new EBWizardry();

        @Config.Name("EnderIOConduits")
        public final EnderIOConduits enderIOConduits = new EnderIOConduits();

        @Config.Name("FluxNetworks")
        public final FluxNetworks fluxNetworks = new FluxNetworks();

        @Config.Name("IC2")
        public final IC2 ic2 = new IC2();

        @Config.Name("LazyAE2")
        public final LazyAE2 lazyAE2 = new LazyAE2();

        @Config.Name("LegendaryTooltips")
        public final LegendaryTooltips legendaryTooltips = new LegendaryTooltips();

        @Config.Name("Mekanism")
        public final Mekanism mekanism = new Mekanism();

        @Config.Name("NuclearCraftOverhauled")
        public final NuclearCraftOverhauled nuclearCraftOverhauled = new NuclearCraftOverhauled();

        @Config.Name("RGBChat")
        public final RGBChat rgbChat = new RGBChat();

        @Config.Name("Techguns")
        public final Techguns techguns = new Techguns();

        @Config.Name("MoreElectricTools")
        public final MoreElectricTools moreElectricTools = new MoreElectricTools();

        public static class Vanilla {

            @Config.Comment("(Server) Allows CriterionProgress to be serialized in multiple threads.")
            @Config.RequiresMcRestart
            @Config.Name("AsyncAdvancementSerialize")
            public boolean asyncAdvancementSerialize = true;

            @Config.Comment({
                    "An extra feature that stops the model loader from printing errors, neat log, no?",
                    "May have implications for Debug, cannot prevent errors in the output of custom loaders. only available if ParallelModelLoader is enabled."
            })
            @Config.RequiresMcRestart
            @Config.Name("ShutUpModelLoader")
            public boolean shutUpModelLoader = false;

            @Config.Comment("(Client Only) Listening to clients loading/unloading new worlds, disabling this option will cause some features on memory leak fixing to fail.")
            @Config.RequiresMcRestart
            @Config.Name("HandleClientWorldLoad")
            public boolean handleClientWorldLoad = true;

        }

        public static class FontScale {

            @Config.Comment("(Client) Allows you to modify the specific scaling of small fonts in the AE2 GUI.")
            @Config.RangeDouble(min = 0.25F, max = 1.0F)
            @Config.Name("AppliedEnergetics2")
            public float ae2 = 0.5F;

            @Config.Comment("(Client) Allows you to modify the specific scaling of small fonts in the EnderUtilities GUI.")
            @Config.RangeDouble(min = 0.25F, max = 1.0F)
            @Config.Name("EnderUtilities")
            public float enderUtilities = 0.5F;

        }

        public static class AstralSorcery {

            @Config.Comment("Disables AstralSorcery's ChainMining perk, make that doesn't work.")
            @Config.Name("DisableChainMining")
            public boolean disableChainMining = false;

        }

        public static class BetterChat {

            @Config.Comment("(Client) Message compat (probably does the same thing as UniversalTweaks, but the difference is that this is a special compatibility with the BetterChat mod).")
            @Config.Name("EnableMessageCompat")
            public boolean messageCompat = false;

        }

        public static class Botania {

            @Config.Comment("As the name suggests, use at your own risk.")
            @Config.Name("DisableCosmeticRecipe")
            public boolean disableCosmeticRecipe = false;

        }
        
        public static class EBWizardry {

            @Config.Comment("Prevents the WizardSpell loot from logging to the server console when it's casted.")
            @Config.Name("PreventWizardSpellLogSpam")
            public boolean preventWizardSpellLogSpam = false;

        }

        public static class EnderIOConduits {

            @Config.Comment("If you're really tired of all this useless logging, set it to true (filter only the no side effects section).")
            @Config.Name("PrevEnderLiquidConduitNetworkLogSpam")
            public boolean prevEnderLiquidConduitLogSpam = true;

        }
        
        public static class FluxNetworks {

            @Config.Comment("(Server) Make FluxNetworks to generate a random int uid for each network, instead of using the self-incrementing ID.")
            @Config.Name("RandomNetworkUniqueID")
            public boolean randomNetworkUniqueID = false;

        }

        public static class IC2 {

            @Config.Comment({
                    "A highly intrusive feature that makes the IC2 and most of its Addon mod's power items no longer use the endurance value to",
                    "display power, but instead use a special display, a feature that disables the endurance value and helps automate the crafting."
            })
            @Config.Name("ElectricItemNonDurability")
            public boolean electricItemNonDurability = false;

        }

        public static class LazyAE2 {

            @Config.Comment("The Level Maintainer request synthesis will always be made to the set value, not just to the critical value.")
            @Config.Name("LevelMaintainerRequestCountImprovements")
            public boolean levelMaintainerRequest = false;

        }

        public static class LegendaryTooltips {

            @Config.Comment("(Client) As the name suggests, enable it only when necessary.")
            @Config.Name("DisableTitleWrap")
            public boolean tooltipDecor = false;

        }

        public static class Mekanism {

            @Config.Comment({
                    "Allows TheOneProbe to show that Mekanism's machines exceed 2147483647 units of energy.",
                    "MEKCEu already includes this feature, so installing MEKCEu will automatically disable it."
            })
            @Config.RequiresMcRestart
            @Config.Name("TOPSupport")
            public boolean topSupport = true;

            @Config.Comment({
                    "Allows Mekanism's machines to transmit more than 2147483647 units of energy through FluxNetworks.",
                    "MEKCEu already includes this feature, so installing MEKCEu will automatically disable it."
            })
            @Config.Name("FluxNetworksSupport")
            public boolean fluxNetworksSupport = true;

        }

        public static class NuclearCraftOverhauled {

            @Config.Comment("Completely disable NuclearCraft: Overhauled's radiation system if you really don't want to see them in every item's NBT, haha.")
            @Config.Name("DisableRadiationCapability")
            public boolean removeRadiationCapabilityHandler = false;

        }

        public static class RGBChat {

            @Config.Comment("(Client) Complete rewrite of RGBChat's font renderer to optimize performance and fix crashes.")
            @Config.Name("TrueRGBSimpleRendererImprovements")
            public boolean cachedRGBFontRenderer = true;

        }

        public static class Techguns {

            @Config.Comment("Safe mode is used by default for every player.")
            @Config.Name("ForceSecurityMode")
            public boolean forceSecurityMode = true;

            @Config.Comment("Are bullets treated as projectiles (affecting damage determination)?")
            @Config.Name("BulletIsProjectile")
            public boolean tgDamageSource = false;

        }

        public static class MoreElectricTools {

            @Config.Comment("Disable the Efficient enchantment, if you think this enchantment will appear on any item it's just too bad.")
            @Config.Name("RemoveEfficientEnergyCostEnchantment")
            public boolean disableEfficientEnergyCost = false;

        }

    }

    /*
        必须在最后加载。
     */
    static {
        ConfigAnytime.register(StellarCoreConfig.class);
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(StellarCore.MOD_ID)) {
            ConfigManager.sync(StellarCore.MOD_ID, Config.Type.INSTANCE);

            if (FMLLaunchHandler.side().isClient()) {
                ParallelModelLoaderAsyncBlackList.INSTANCE.reload();
                // Pool does not reference minecraft class, so is safety.
                if (StellarUnpackedDataPool.update()) {
                    StellarUnpackedDataPool.reset();
                }
            }
        }
    }

}
