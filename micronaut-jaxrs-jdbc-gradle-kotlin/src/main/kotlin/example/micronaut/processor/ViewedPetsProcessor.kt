/*
 * Copyright 2017-2024 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.micronaut.processor

import example.micronaut.Pet
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapNotNull

class ViewedPetsProcessor {


    //to instrument with otel methods instrumentation
    //comment all @WithSpan and add environment variable
    //OTEL_INSTRUMENTATION_METHODS_INCLUDE=
    // org.springframework.samples.petclinic.processors.ViewedOwnersProcessor[processOwners,getOwnerName,filterByName,getExcludeList]

    @ExperimentalCoroutinesApi
    @FlowPreview
//    @WithSpan
//    @NewSpan
    suspend fun processPets(pets: Flow<Pet>){

        pets
            .mapNotNull {
                getPetName(it)
            }
            .filter { filterByName(it) }
            .collect{
                println("found $it at ${kotlinx.datetime.Clock.System.now()}")
            }
    }


//    @WithSpan
//    @NewSpan
    suspend fun getPetName(pet: Pet): String {
        delay(100)
        return pet.name
    }

//    @WithSpan
//    @NewSpan
    suspend fun filterByName(ownerName: String): Boolean {
        delay(100)
        return !getExcludeList().contains(ownerName)
    }

//    @WithSpan
//    @NewSpan
    suspend fun getExcludeList():List<String>{
        delay(10)
        return listOf("Rambo")
    }

}
