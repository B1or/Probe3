package tech.droi.probe3

import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }
    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }
    @Provides
    fun provideRam(): RAM {
        return RAM()
    }
    @Provides
    fun provideAxe(): Axe {
        return Axe()
    }
}
